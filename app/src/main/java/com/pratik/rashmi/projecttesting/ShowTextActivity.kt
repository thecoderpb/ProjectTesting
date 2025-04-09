package com.pratik.rashmi.projecttesting

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ShowTextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_show_text)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Get the message from the Intent.
        val intent = intent
        val message: String = intent.getStringExtra(
            KEY_EXTRA_MESSAGE
        ).toString()


        // Show message.
        (findViewById<View>(R.id.show_text_view) as TextView).text =
            message
    }


    companion object {
        private const val KEY_EXTRA_MESSAGE: String = "com.pratik.rashmi.projecttesting.MESSAGE"

        fun newStartIntent(context: Context?, message: String?): Intent {
            val newIntent = Intent(context, ShowTextActivity::class.java)
            newIntent.putExtra(KEY_EXTRA_MESSAGE, message)
            return newIntent
        }
    }
}