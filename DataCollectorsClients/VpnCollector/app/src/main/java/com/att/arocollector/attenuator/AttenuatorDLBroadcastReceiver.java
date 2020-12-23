/*
 *  Copyright 2018 AT&T
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.att.arocollector.attenuator;


import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import com.att.arocollector.R;


public class AttenuatorDLBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = AttenuatorDLBroadcastReceiver.class.getSimpleName();

    private NotificationCompat.Builder mBuilder;
    public static final String CHANNEL_ID = "VPN Collector VPN Notification";

    public AttenuatorDLBroadcastReceiver() {
        super();

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        int dlMs = intent.getIntExtra("dlms" ,0);
        String text = "Download stream delay for "+ dlMs+ " ms";
        Log.i(TAG, text);

        // Check for negative delay
        if(dlMs >= 0) {
            AttenuatorManager.getInstance().setDelayDl(dlMs);
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show();

            NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            createNotificationChannel(mNotificationManager);
            if (mBuilder == null) {
                mBuilder = new NotificationCompat.Builder(context, CHANNEL_ID)
                                                 .setSmallIcon(R.drawable.icon)
                                                 .setContentTitle("Video Optimizer VPN Collector")
                                                 .setAutoCancel(false)
                                                 .setOngoing(true);
            }

            mBuilder.setContentText(AttenuatorUtil.getInstance().notificationMessage());
            mNotificationManager.notify(1, mBuilder.build());
        } else{
            Log.i(TAG,"Invalid attenuation delay packet value: "+ dlMs + "ms");
        }

    }

    private void createNotificationChannel(NotificationManager mNotificationManager) {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel serviceChannel = new NotificationChannel(
                    CHANNEL_ID,
                    "VPN Collector",
                    NotificationManager.IMPORTANCE_DEFAULT
            );

            mNotificationManager.createNotificationChannel(serviceChannel);
        }
    }

}

