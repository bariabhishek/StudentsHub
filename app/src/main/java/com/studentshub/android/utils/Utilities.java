package com.studentshub.android.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.Log;

import com.studentshub.android.app.Application;
import com.studentshub.android.models.device_model.DeviceInfo;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class Utilities {


    //*********** Checks if the Device is Connected to any Network ********//

    public static boolean isNetworkAvailable(Activity activity) {

        ConnectivityManager connectivity = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            Network[] networks = new Network[0];
            if (connectivity != null) {
                networks = connectivity.getAllNetworks();
            }
            NetworkInfo networkInfo;

            for (Network mNetwork : networks) {

                networkInfo = connectivity.getNetworkInfo(mNetwork);

                if (networkInfo.getState().equals(NetworkInfo.State.CONNECTED)) {
                    return true;
                }
            }

        } else {
            if (connectivity != null) {

                NetworkInfo[] info = connectivity.getAllNetworkInfo();

                if (info != null) {
                    for (NetworkInfo networkInfo : info) {
                        if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }


    //*********** Used to check if the App is running in Foreground ********//

    public static boolean isAppInForeground() {
        ActivityManager activityManager = (ActivityManager) Application.getContext().getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> services = null;
        if (activityManager != null) {
            services = activityManager.getRunningAppProcesses();
        }
        boolean isActivityFound = false;

        if (services.get(0).processName.equalsIgnoreCase(Application.getContext().getPackageName())) {
            Log.i("test", "PackageName=" + Application.getContext().getPackageName());
            isActivityFound = true;
        }

        return isActivityFound;
    }


    //*********** Used to Print the HashKey (SHA) ********//

    public static void printHashKey() {
        try {
            PackageInfo info = Application.getContext().getPackageManager().getPackageInfo(Application.getContext().getPackageName(), PackageManager.GET_SIGNATURES);

            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }

        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }


    //*********** Convert given String to Md5Hash ********//

    public static String getMd5Hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            StringBuilder md5 = new StringBuilder(number.toString(16));

            while (md5.length() < 32)
                md5.insert(0, "0");

            return md5.toString();
        } catch (NoSuchAlgorithmException e) {
            Log.e("MD5", e.getLocalizedMessage());
            return null;
        }
    }


    //*********** Returns information of the Device ********//

    @SuppressLint("HardwareIds")
    public static DeviceInfo getDeviceInfo(Context context) {

        String IMEI = "";
        String NETWORK = "";
        String PROCESSORS = "";


        String UNIQUE_ID = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        PROCESSORS = String.valueOf(Runtime.getRuntime().availableProcessors());

        ActivityManager actManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo memInfo = new ActivityManager.MemoryInfo();
        if (actManager != null) {
            actManager.getMemoryInfo(memInfo);
        }
        double totalRAM = Math.round(((memInfo.totalMem / 1024.0) / 1024.0) / 1024.0);


        if (CheckPermissions.is_PHONE_STATE_PermissionGranted()) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            try {
                if (telephonyManager != null) {
                    IMEI = telephonyManager.getDeviceId();
                    NETWORK = telephonyManager.getNetworkOperatorName();
                }

            } catch (SecurityException | NullPointerException e) {
                e.printStackTrace();
            }
        }


        DeviceInfo device = new DeviceInfo();

        device.setDeviceID(UNIQUE_ID);
        device.setDeviceType("1");
        device.setDeviceUser(Build.USER);
        device.setDeviceModel(Build.BRAND + " " + Build.MODEL);
        device.setDeviceBrand(Build.BRAND);
        device.setDeviceSerial(Build.SERIAL);
        device.setDeviceSystemOS(System.getProperty("os.name"));
        device.setDeviceAndroidOS("Android " + Build.VERSION.RELEASE);
        device.setDeviceManufacturer(Build.MANUFACTURER);
        device.setDeviceIMEI(IMEI);
        device.setDeviceRAM(totalRAM + "GB");
        device.setDeviceCPU(Build.UNKNOWN);
        device.setDeviceStorage(Build.UNKNOWN);
        device.setDeviceProcessors(PROCESSORS);
        device.setDeviceIP(Build.UNKNOWN);
        device.setDeviceMAC(Build.UNKNOWN);
        device.setDeviceNetwork(NETWORK);
        device.setDeviceBatteryLevel(Build.UNKNOWN);
        device.setDeviceBatteryStatus(Build.UNKNOWN);

        return device;
    }


    //*********** Returns the current DataTime of Device ********//

    public static String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();

        return dateFormat.format(date);
    }


    //*********** Checks if the Date is not Passed ********//

    public static boolean checkIsDatePassed(String givenDate) {

        boolean isPassed = false;

        Date dateGiven, dateSystem;

        Calendar calender = Calendar.getInstance();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDate = dateFormat.format(calender.getTime());

        try {
            dateSystem = dateFormat.parse(currentDate);
            dateGiven = dateFormat.parse(givenDate);

            if (dateSystem.getTime() >= dateGiven.getTime()) {
                isPassed = true;
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return isPassed;
    }

}

