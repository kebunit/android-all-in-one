package com.kebunit.androidallinone.activity.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.RemoteViews;

import com.kebunit.androidallinone.R;

public class NotificationGenerator {
    public static NotificationManagerCompat notificationManagerCompat;
    public static int NOTIF_ID = 1001;


    public static void generate(Context context, String channelID) {
        RemoteViews notificationLayout = new RemoteViews(context.getPackageName(), R.layout.notif_view);
        RemoteViews notificationLayoutExpanded = new RemoteViews(context.getPackageName(), R.layout.notif_expand);

        Intent intent = new Intent(context, NotificationReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);

        notificationLayoutExpanded.setOnClickPendingIntent(R.id.image_notif, pendingIntent);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, channelID)
                .setSmallIcon(R.drawable.logo_apps)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCustomBigContentView(notificationLayoutExpanded)
                .setCustomContentView(notificationLayout)
                .setStyle(new NotificationCompat.DecoratedCustomViewStyle())
                .setOnlyAlertOnce(true)
                .setAutoCancel(true);
        notificationManagerCompat = NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(NOTIF_ID, builder.build());
    }
}
