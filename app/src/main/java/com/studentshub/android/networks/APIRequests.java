package com.studentshub.android.networks;


import com.studentshub.android.models.user_model.UserData;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIRequests {


    //******************** Notifications Data ********************//

    @FormUrlEncoded
    @POST("registerdevices")
    Single<UserData> registerDeviceToFCM(@Field("device_id") String device_id,
                                         @Field("user_id") int user_id,
                                         @Field("ram") String ram,
                                         @Field("processor") String processor,
                                         @Field("device_os") String device_os,
                                         @Field("device_model") String device_model,
                                         @Field("manufacturer") String manufacturer);



}

