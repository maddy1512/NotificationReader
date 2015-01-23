package com.maitray.notifier;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.service.notification.NotificationListenerService;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;

public class NotificationListener extends AccessibilityService {
    public NotificationListener() {
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        Log.e("NOTIFICATION","Entered service");
        //Log.e("NOTIFICATION RECIEVED","notification: " + event.getText());
        if (event.getEventType() == AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED) {
            Log.e("NOTIFICATION RECIEVED","notification: " + event.getText()+" "+event.getPackageName());

        }

    }

    @Override
    public void onInterrupt() {
        Log.e("NOTIFICATION","Entered onTnterrupt");
    }

    @Override
    protected void onServiceConnected() {
        Log.e("NOTIFICATION","onServiceConnected");
        AccessibilityServiceInfo info = new AccessibilityServiceInfo();
        info.eventTypes = AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED;
        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_ALL_MASK;
        info.notificationTimeout = 100;
        setServiceInfo(info);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }



}
