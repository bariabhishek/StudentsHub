package com.studentshub.android.networks;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.studentshub.android.app.Application;
import com.studentshub.android.models.device_model.DeviceInfo;
import com.studentshub.android.models.user_model.UserData;
import com.studentshub.android.utils.Utilities;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;


public class StartAppRequests {

    private Application app;
    private static CompositeDisposable disposable = new CompositeDisposable();


    public StartAppRequests(Context context) {
        app = ((Application) context.getApplicationContext());
    }

    public static void RegisterDeviceForFCM(int user_ID, Context context, String deviceID) {

        DeviceInfo device = Utilities.getDeviceInfo(context);

        Single<UserData> call = APIClient.getInstance().registerDeviceToFCM
                (
                        deviceID,
                        user_ID,
                        device.getDeviceRAM(),
                        device.getDeviceProcessors(),
                        device.getDeviceAndroidOS(),
                        device.getDeviceModel(),
                        device.getDeviceManufacturer()
                );

        disposable.add(call
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<UserData>() {
                    @Override
                    public void onSuccess(UserData userData) {

                        if (userData.getSuccess().equalsIgnoreCase("1")) {

                            Log.i("Device Registered", userData.getMessage());
                            Toast.makeText(context, "Inserted Token", Toast.LENGTH_LONG).show();


                        } else if (userData.getSuccess().equalsIgnoreCase("2")) {

                            Log.i("Device Updated", userData.getMessage());
                            Toast.makeText(context, "Updated Token", Toast.LENGTH_LONG).show();

                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("notifications", e.getMessage());
                        Toast.makeText(context, "Failed Token", Toast.LENGTH_LONG).show();


                    }
                }));


    }

}
