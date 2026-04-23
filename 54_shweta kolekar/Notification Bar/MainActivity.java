package com.example.messageapp;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MainActivity extends AppCompatActivity {

    Button btnSend;
    String channelId = "msg_channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSend = findViewById(R.id.btnSend);

        // Android 13+ permission request
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requestPermissions(new String[]{
                    android.Manifest.permission.POST_NOTIFICATIONS
            }, 1);
        }

        createChannel();

        btnSend.setOnClickListener(v -> showNotification());
    }

    // 🔥 MUST FOR HEADS-UP
    private void createChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationChannel channel = new NotificationChannel(
                    channelId,
                    "Message Channel",
                    NotificationManager.IMPORTANCE_HIGH // ⭐ KEY POINT
            );

            channel.setDescription("WhatsApp style messages");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }

    // 🔥 THIS MAKES TOP BANNER NOTIFICATION
    private void showNotification() {

        Intent intent = new Intent(this, MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(
                this,
                0,
                intent,
                PendingIntent.FLAG_IMMUTABLE
        );

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this, channelId)
                        .setSmallIcon(android.R.drawable.sym_action_chat)
                        .setContentTitle("WhatsApp")
                        .setContentText("👤 SHWETA: Hey! Are you free?")
                        .setPriority(NotificationCompat.PRIORITY_HIGH) // ⭐ IMPORTANT
                        .setCategory(NotificationCompat.CATEGORY_MESSAGE) // ⭐ IMPORTANT
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true);

        NotificationManagerCompat manager = NotificationManagerCompat.from(this);
        manager.notify(100, builder.build());
    }
}