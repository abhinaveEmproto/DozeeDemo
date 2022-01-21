package com.example.tvdemoapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.tvdemoapp.R
import com.example.tvdemoapp.dataModel.LoginRequest
import com.example.tvdemoapp.dataModel.LoginResponse
import com.example.tvdemoapp.dataModel.OtpRequest
import com.example.tvdemoapp.viewModel.AuthViewmodel


/**
 * Loads [MainFragment].
 */
class LoginActivity : FragmentActivity() {
    lateinit var viewModel: AuthViewmodel

    lateinit var otp_btn: Button
    lateinit var email_input: EditText
    lateinit var otp_input:EditText
    lateinit var layout_otp:LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        otp_btn = findViewById(R.id.otp_btn)
        email_input = findViewById(R.id.email_input)
        otp_input = findViewById(R.id.otp_input)
        layout_otp = findViewById(R.id.layout_otp)
        initViewModel()

        otp_btn.setOnClickListener(View.OnClickListener {
            createOTP()
        })

    }

    private fun createOTP() {
        val loginRequest = LoginRequest("Email", email_input.text.toString())
        viewModel.getSessionId(loginRequest).observe(this, Observer<LoginResponse?> {
            if (it == null) {
                Toast.makeText(this@LoginActivity, "Failed to create", Toast.LENGTH_LONG).show()

            } else {
                Toast.makeText(this@LoginActivity, "Please Check Your Email for OTP", Toast.LENGTH_LONG).show()
                layout_otp.isVisible=true;
                email_input.isEnabled=false;
                otp_btn.setText("Submit")
                var sessionId:String="";
                sessionId=it.SessionId
                otp_btn.setOnClickListener(View.OnClickListener {
                    if (!otp_input.text.isNullOrEmpty()) {
                        submitOtp(sessionId,email_input.text.toString(),otp_input.text.toString())
                    }else{
                        Toast.makeText(this@LoginActivity, "Please Enter Valid OTP", Toast.LENGTH_LONG).show()
                    }
                })
            }
        })
    }

    private fun submitOtp(sessionId: String, email:String,otp: String) {
        val otpRequest=OtpRequest("Email",email,sessionId,otp)
        viewModel.submitOtp(otpRequest).observe(this, Observer {
            if (it!=null) {
                startActivity(Intent(this, DashboardActivity::class.java))
                finish()
            }
        })
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(AuthViewmodel::class.java)

    }
}

