package com.studentshub.android.networks;


import com.studentshub.android.constants.ConstantValues;
import com.studentshub.android.utils.Utilities;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class APIClient {


    // Base URL for API Requests
    private static final String BASE_URL = ConstantValues.APP_URL + "api/";

    private static APIRequests apiRequests;

    // Singleton Instance of APIRequests
    public static APIRequests getInstance() {
        if (apiRequests == null) {

            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            API_Interceptor apiInterceptor = new API_Interceptor.Builder()
                    .trainerKey(Utilities.getMd5Hash(ConstantValues.APP_TRAINER_KEY))
                    .trainerSecret(Utilities.getMd5Hash(ConstantValues.APP_TRAINER_SECRET))
                    .build();

            OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
                    .addInterceptor(apiInterceptor)
                    .addInterceptor(httpLoggingInterceptor)
                    .build();


            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();


            apiRequests = retrofit.create(APIRequests.class);

            return apiRequests;
        } else {
            return apiRequests;
        }
    }

}


