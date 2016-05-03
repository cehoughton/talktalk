package com.epicodus.talktalk;

import android.app.Application;

import com.firebase.client.Firebase;

public class TalkTalkApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
