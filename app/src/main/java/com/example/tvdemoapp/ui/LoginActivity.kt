package com.example.tvdemoapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.FragmentActivity
import com.example.tvdemoapp.R

/**
 * Loads [MainFragment].
 */
class LoginActivity : FragmentActivity() {

    lateinit var otp_btn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        otp_btn= findViewById(R.id.otp_btn)

        otp_btn.setOnClickListener(View.OnClickListener {
            val intent= Intent(this, OtpActivity::class.java)
            startActivity(intent)
            finish()
        })
    }
}