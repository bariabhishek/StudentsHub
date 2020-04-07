package com.studentshub.android.services;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.studentshub.android.activities.MainActivity;
import com.studentshub.android.utils.NotificationHelper;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;


public class MyFirebaseMessagingService extends FirebaseMessagingService {


    //*********** Called when the Notification is Received ********//

    @Override
    public void onNewToken(@NonNull String s) {

        super.onNewToken(s);

    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        Bitmap notificationBitmap;
        String notification_title, notification_message, notification_image = "";


        if (remoteMessage.getData().size() > 0) {
            notification_title = remoteMessage.getData().get("title");
            notification_message = remoteMessage.getData().get("message");
            notification_image = remoteMessage.getData().get("image");
        } else {
            notification_title = Objects.requireNonNull(remoteMessage.getNotification()).getTitle();
            notification_message = remoteMessage.getNotification().getBody();
        }


        notificationBitmap = getBitmapFromUrl(notification_image);

        Intent notificationIntent = new Intent(getApplicationContext(), MainActivity.class);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);

        NotificationHelper.showNewNotification
                (
                        getApplicationContext(),
                        notificationIntent,
                        notification_title,
                        notification_message,
                        notificationBitmap
                );

    }


    public Bitmap getBitmapFromUrl(String imageUrl) {
        if ("".equalsIgnoreCase(imageUrl)) {
            return null;
        } else {
            try {
                URL url = new URL(imageUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream input = connection.getInputStream();
                return BitmapFactory.decodeStream(input);

            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

}
