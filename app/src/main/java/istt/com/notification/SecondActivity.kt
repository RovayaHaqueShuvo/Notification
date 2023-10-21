package istt.com.notification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import istt.com.notification.databinding.ActivityMainBinding
import istt.com.notification.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySecondBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.DataRecive.setText(intent.getStringExtra("Data_Passing"))
    }
}