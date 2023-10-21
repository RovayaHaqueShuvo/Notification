package istt.com.notification

import android.app.NotificationManager
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
        binding.button.setOnClickListener {
            val notification = NotificationCompat.Builder(this@MainActivity, App().Channel_ID1)
            notification.setContentTitle(binding.editText.text.toString())
            notification.setContentText(binding.editText2.text.toString())
            notification.setSmallIcon(R.drawable.up_arrow)
                .build()

            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(1,notification.build())
        }

        binding.button1.setOnClickListener {
            val notification = NotificationCompat.Builder(this,App().Channel_ID2)
            notification.setContentTitle(binding.editText.text.toString())
            notification.setContentText(binding.editText2.text.toString())
            notification.setSmallIcon(R.drawable.down_arrow).build()

            val namager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            namager.notify(1, notification.build())
        }
    }
}