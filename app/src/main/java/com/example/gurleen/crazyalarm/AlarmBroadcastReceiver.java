package com.example.gurleen.crazyalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.gurleen.crazyalarm.utilities.NotificationUtils;

public class AlarmBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationUtils.alarmNotification(context);
    }
}
