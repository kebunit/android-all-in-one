package com.kebunit.androidallinone.activity.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationManagerCompat;

import com.kebunit.androidallinone.activity.home.MainActivity;

public class NotificationReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        notificationManagerCompat.cancel(NotificationGenerator.NOTIF_ID);
        Intent intentx = new Intent(context, MainActivity.class);
        context.startActivity(intentx);
    }
}
