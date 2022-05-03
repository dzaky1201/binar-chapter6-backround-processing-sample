package com.dzakyhdr.ch6_sample_backround_processing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.view.View
import com.dzakyhdr.ch6_sample_backround_processing.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtTitile.setOnClickListener {
            Thread {
                run {
                    val text = loadText("Hallo saya dzaky")
                    val msg = Message.obtain()
                    msg.obj = text
                    msg.target = handler
                    msg.sendToTarget()
                }

            }.start()
        }
    }

    private val handler = object : Handler(Looper.getMainLooper()){
        override fun handleMessage(msg: Message) {
            val message = msg.obj as String
            binding.txtTitile.text = message
        }
    }


    private fun loadText(title: String): String {
        return title
    }

}