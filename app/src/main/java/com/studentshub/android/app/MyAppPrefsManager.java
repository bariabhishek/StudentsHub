package com.studentshub.android.app;

import android.content.Context;
import android.content.SharedPreferences;


public class MyAppPrefsManager {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor prefsEditor;

    private int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "StudentsHub_Prefs";


    private static final String IS_TRAINER_LOGGED_IN = "isLogged_in";


    public MyAppPrefsManager(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        prefsEditor = sharedPreferences.edit();
    }


    public void setUserLoggedIn(boolean isTrainerLoggedIn) {
        prefsEditor.putBoolean(IS_TRAINER_LOGGED_IN, isTrainerLoggedIn);
        prefsEditor.commit();
    }

    public boolean isUserLoggedIn() {
        return sharedPreferences.getBoolean(IS_TRAINER_LOGGED_IN, false);
    }


}
