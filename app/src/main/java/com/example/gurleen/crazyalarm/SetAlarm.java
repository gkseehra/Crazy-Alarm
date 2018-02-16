package com.example.gurleen.crazyalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class SetAlarm extends AppCompatActivity {
    TimePicker tp;
    private static final String ACTION_NOTIFY = "com.example.android.crazyalarm.ACTION_NOTIFY";
    private static final int ALARM_NOTIFICATION_ID =101;
    AlarmManager alarmManager;
    PendingIntent nPendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_alarm);
        Intent nIntent = new Intent(ACTION_NOTIFY);
        nPendingIntent = PendingIntent.getBroadcast(this,ALARM_NOTIFICATION_ID, nIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        tp=(TimePicker)findViewById(R.id.timeSet);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void createAlarm(View view) {
        //alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, timeToRingAlarm, AlarmManager.INTERVAL_FIFTEEN_MINUTES, nPendingIntent);
        int hr = tp.getCurrentHour();
        int min = tp.getCurrentMinute();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hr);
        calendar.set(Calendar.MINUTE, min);
        long timeToRingAlarm = calendar.getTimeInMillis();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, timeToRingAlarm, nPendingIntent);
        }
        Toast.makeText(this, "Alarm Created", Toast.LENGTH_SHORT);

    }

    public void cancelAlarm(View view) {

        alarmManager.cancel(nPendingIntent);
    }
}
