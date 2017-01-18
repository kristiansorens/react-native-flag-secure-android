// Adapted from
// https://github.com/gijoehosaphat/react-native-keep-screen-on

package com.kristiansorens.flagsecure;

import android.app.Activity;
import android.view.WindowManager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class FlagSecure extends ReactContextBaseJavaModule {

    public FlagSecure(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "FlagSecure";
    }

    @ReactMethod
    public void activate() {
        final Activity activity = getCurrentActivity();

        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);
                }
            });
        }
    }

    @ReactMethod
    public void deactivate() {
        final Activity activity = getCurrentActivity();

        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    activity.getWindow().clearFlags(android.view.WindowManager.LayoutParams.FLAG_SECURE);
                }
            });
        }
    }
}
