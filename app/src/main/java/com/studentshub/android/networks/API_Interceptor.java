package com.studentshub.android.networks;

import android.util.Log;

import androidx.annotation.NonNull;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class API_Interceptor implements Interceptor {

    private static final String APP_TRAINER_KEY = "trainer-key";
    private static final String APP_TRAINER_SECRET = "trainer-secret";

    private String trainerKey;
    private String trainerSecret;


    private API_Interceptor(String trainerKey, String trainerSecret) {
        this.trainerKey = trainerKey;
        this.trainerSecret = trainerSecret;
    }


    @NonNull
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        HttpUrl originalHttpUrl = original.url();


        Log.d("Wyngd Trainer: ", APP_TRAINER_KEY + " = " + trainerKey);
        Log.d("Wyngd Trainer Secret:", APP_TRAINER_SECRET + " = " + trainerSecret);

        HttpUrl url = originalHttpUrl.newBuilder().build();

        // Request customization: add request headers
        Request.Builder requestBuilder = original.newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader(APP_TRAINER_KEY, trainerKey)
                .addHeader(APP_TRAINER_SECRET, trainerSecret)
                .url(url);


        Request request = requestBuilder.build();
        return chain.proceed(request);
    }


    public static final class Builder {

        private String trainerKey;
        private String trainerSecret;

        public Builder trainerKey(String trainerKey) {
            if (trainerKey == null) throw new NullPointerException("trainerKey = null");
            this.trainerKey = trainerKey;
            return this;
        }

        public Builder trainerSecret(String trainerSecret) {
            if (trainerSecret == null) throw new NullPointerException("trainerSecret = null");
            this.trainerSecret = trainerSecret;
            return this;
        }


        public API_Interceptor build() {

            if (trainerKey == null) throw new IllegalStateException("trainerKey not set");
            if (trainerSecret == null) throw new IllegalStateException("trainerSecret not set");

            return new API_Interceptor(trainerKey, trainerSecret);
        }
    }

    public String urlEncoded(String url) {
        String encodedURL = "";
        try {
            encodedURL = URLEncoder.encode(url, "UTF-8");
            Log.d("encodedURL", encodedURL);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return encodedURL;
    }
}
