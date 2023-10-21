package istt.com.notification

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class App:Application() {
     val Channel_ID1 = "CHANNEL_ID1"
     val Channel_ID2 = "CHANNEL_ID2"

    override fun onCreate() {
        super.onCreate()
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            val channel_1= NotificationChannel(Channel_ID1,
                "Camera", NotificationManager.IMPORTANCE_HIGH)
            channel_1.description = "High Passing Notification"

            val channel_2 = NotificationChannel(Channel_ID2, "Phone", NotificationManager.IMPORTANCE_LOW)
            channel_2.description="Low Passing Notification"

            val manager= getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel_1)
            manager.createNotificationChannel(channel_2)

        }
    }
}