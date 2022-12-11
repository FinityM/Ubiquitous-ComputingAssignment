package com.example.rsswebreader;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;


public class MainActivity extends AppCompatActivity {
    public static final String NOTIFICATION_CHANNEL_ID = "10001" ;
    private final static String default_notification_channel_id = "default" ;

    private EditText rssUrlTextField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rssUrlTextField = findViewById(R.id.rssUrlTextField);
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, RSSFeedActivity.class);
        String url = rssUrlTextField.getText().toString();
        intent.putExtra("url", url);

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("10002",
                    "CHANNEL_NAME",
                    NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("CHANNEL_DESCRIPTION");
            notificationManager.createNotificationChannel(channel);
        }

        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, default_notification_channel_id )
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle( "RSS Feed Updated" )
                .setContentText( "New Articles" )
                .setAutoCancel( true )
                .setSound(notification);
        notificationManager.notify(0, builder.build());
        startActivity(intent);
    }
}
