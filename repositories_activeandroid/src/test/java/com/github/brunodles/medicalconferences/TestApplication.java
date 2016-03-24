package com.github.brunodles.medicalconferences;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

/**
 * Created by bruno on 15/03/16.
 */
public class TestApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }
}
