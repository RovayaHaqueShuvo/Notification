package istt.com.notification

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import istt.com.notification.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val intent = Intent(this@MainActivity,SecondActivity::class.java)
        binding.HighBtn.setOnClickListener {
            val notification = NotificationCompat.Builder(this@MainActivity, App().Channel_ID1)
            notification.setContentTitle(binding.TitleEdTxt.text.toString())
            notification.setContentText(binding.ContentEdTxt.text.toString())
            notification.setSmallIcon(R.drawable.up_arrow)

            val pendingIntent = PendingIntent.getActivity(this,0, intent, PendingIntent.FLAG_MUTABLE)

            notification.setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setColor(Color.MAGENTA)
                .addAction(R.drawable.up_arrow,"Back",pendingIntent)
                .addAction(R.drawable.up_arrow,"Play",pendingIntent)
                .addAction(R.drawable.up_arrow,"Next",pendingIntent)
                .setOnlyAlertOnce(true)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .build()

            intent.putExtra("Data_Passing",binding.ContentEdTxt.text.toString())

            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(1,notification.build())
        }

        binding.LowBtn.setOnClickListener {
            val notification = NotificationCompat.Builder(this,App().Channel_ID2)
            notification.setContentTitle(binding.TitleEdTxt.text.toString())
            notification.setContentText(binding.ContentEdTxt.text.toString())
            notification.setSmallIcon(R.drawable.down_arrow)
                notification.setPriority(NotificationCompat.PRIORITY_LOW).build()

            val namager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            namager.notify(1, notification.build())
        }
    }
}