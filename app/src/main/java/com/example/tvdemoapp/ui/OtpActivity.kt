package com.example.tvdemoapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.FragmentActivity
import com.example.tvdemoapp.R

class OtpActivity : FragmentActivity() {

    lateinit var submit_btn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)

        submit_btn= findViewById(R.id.submit_btn)

        submit_btn.setOnClickListener(View.OnClickListener {
            var intent= Intent(this,DashboardActivity::class.java)
            startActivity(intent)
            finish()
        })
    }
}