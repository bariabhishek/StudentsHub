package com.studentshub.android.app;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.libraries.places.api.Places;
import com.squareup.picasso.Picasso;
import com.studentshub.android.R;
import com.studentshub.android.constants.ConstantValues;
import com.studentshub.android.helpers.ConnectivityReceiver;

import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class Application extends android.app.Application {

    private static Application mInstance;
    private static Context context;
    public static Date startDateTime;

    public static synchronized Application getInstance() {
        return mInstance;
    }

    public static Typeface osBold, osSemibold, osRegular, osExtraBold, osLight, osCondBold;

    public static SharedPreferences prefs;

    public void onCreate() {
        super.onCreate();
        mInstance = this;

        Places.initialize(getApplicationContext(), "AIzaSyCobVRm7pDVZwUoQ3qq4yqJV9PWe-JFymA");

        prefs = PreferenceManager.getDefaultSharedPreferences(this);


//        osBold = Typeface.createFromAsset(getAssets(), "font/proxima_nova_bold.ttf");
//        osSemibold = Typeface.createFromAsset(getAssets(), "font/proxima_nova_semibold.ttf");
//        osRegular = Typeface.createFromAsset(getAssets(), "font/proxima_rova_regular.ttf");
    }


    public void setConnectivityListener(ConnectivityReceiver.ConnectivityReceiverListener listener) {
        ConnectivityReceiver.connectivityReceiverListener = listener;
    }


    public static String TAG = Application.class.getSimpleName();

    public static AlertDialog hud;

    public static void showHUD(Context ctx, String message) {
        AlertDialog.Builder db = new AlertDialog.Builder(ctx);
        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        @SuppressLint("InflateParams") View dialogView = inflater.inflate(R.layout.hud, null);
        TextView msg = dialogView.findViewById(R.id.messageHUD);
        msg.setText(message);

        db.setView(dialogView);
        db.setCancelable(false);
        hud = db.create();
        hud.show();
    }


    public static void hideHUD() {
        hud.dismiss();
    }


    public static void setUserImage(final ImageView imgView, String imgUrl, Context context) {

        String PATH = ConstantValues.APP_URL.concat("public/uploads/user/");

        Picasso.get().load(PATH.concat(imgUrl)).fit().placeholder(R.drawable.default_avatar).into(imgView);


    }


    public static String setMonth(String date) {


        try {
            startDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(startDateTime);

        return new SimpleDateFormat("MM", Locale.getDefault()).format(cal.getTime());
    }


    public static String setDay(String date) {


        try {
            startDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(startDateTime);

        return new SimpleDateFormat("dd", Locale.getDefault()).format(cal.getTime());
    }


    public static String setTime(String date) {


        try {
            startDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        DateFormat sdf = new SimpleDateFormat("hh:mm a", Locale.getDefault());
        String time = sdf.format(startDateTime);
        sdf.setTimeZone(TimeZone.getTimeZone("IST"));
        return time;

    }

    public static String getFormatedAmount(Number amount) {
        return NumberFormat.getNumberInstance(new Locale("en", "IN")).format(amount);
    }


    public static String setFullDate(String date) {


        try {
            startDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(startDateTime);

        return new SimpleDateFormat("dd MMM, yyyy", Locale.getDefault()).format(cal.getTime());
    }


    public static String timeAgoSinceDate(Date date) {
        String dateString = "";
        try {
            @SuppressLint("SimpleDateFormat") SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss");
            String sentStr = (df.format(date));
            Date past = df.parse(sentStr);
            Date now = new Date();
            long seconds = TimeUnit.MILLISECONDS.toSeconds(now.getTime() - past.getTime());
            long minutes = TimeUnit.MILLISECONDS.toMinutes(now.getTime() - past.getTime());
            long hours = TimeUnit.MILLISECONDS.toHours(now.getTime() - past.getTime());
            long days = TimeUnit.MILLISECONDS.toDays(now.getTime() - past.getTime());

            if (seconds < 60) {
                dateString = seconds + " seconds ago";
            } else if (minutes < 60) {
                dateString = minutes + " minutes ago";
            } else if (hours < 24) {
                dateString = hours + " hours ago";
            } else {
                dateString = days + " days ago";
            }
        } catch (Exception j) {
            j.printStackTrace();
        }
        return dateString;
    }


    public static void simpleAlert(String mess, Context activity) {
        AlertDialog.Builder alert = new AlertDialog.Builder(activity);
        alert.setMessage(mess)
                .setPositiveButton("OK", null);
        alert.create().show();
    }


    public static Uri getImageUri(Bitmap bm, Context ctx) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(ctx.getContentResolver(), bm, "image", null);
        return Uri.parse(path);
    }


    public static TranslateAnimation shakeError() {
        TranslateAnimation shake = new TranslateAnimation(0, 10, 0, 0);
        shake.setDuration(500);
        shake.setInterpolator(new CycleInterpolator(7));
        return shake;
    }


    public static Context getContext() {
        return context;
    }

}
