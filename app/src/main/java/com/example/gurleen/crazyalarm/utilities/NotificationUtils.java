package com.example.gurleen.crazyalarm.utilities;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;

import com.example.gurleen.crazyalarm.R;

/**
 * Created by Gurleen on 06-02-2018.
 */

public class NotificationUtils {
    private static final int ALARM_PENDING_INTENT_ID=1;
    private static final int ALARM_NOTIFICATION_ID =101;
    static NotificationManager nManager;
    static NotificationCompat.Builder nBuilder;
    private static PendingIntent createPIntent (Context context){
        Intent startActivity = new Intent(context, Question.class);
        return PendingIntent.getActivity(context, ALARM_PENDING_INTENT_ID,startActivity,PendingIntent.FLAG_UPDATE_CURRENT);
    }

    public static void alarmNotification(Context context){
        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        nManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        nBuilder = new NotificationCompat.Builder(context)
                .setColor(ContextCompat.getColor(context, R.color.purple))
                .setContentTitle(context.getString(R.string.alarm_content_title))
                .setContentIntent(createPIntent(context))
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setAutoCancel(false)
                .setSound(notification);
                ;
        nBuilder.setPriority(NotificationCompat.PRIORITY_HIGH);
        nManager.notify(ALARM_NOTIFICATION_ID, nBuilder.build());

        //MediaPlayer mp = MediaPlayer.create(getApplicationContext(), notification);
        //mp.start();
    }
}
