package com.example.searchcep.view;

import android.app.Application;

import com.facebook.stetho.Stetho;

public class SearchDevsApp extends Application {

    private static SearchDevsApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Stetho.initializeWithDefaults(this);
    }

    public static SearchDevsApp getInstance() {
        return instance;
    }

}
