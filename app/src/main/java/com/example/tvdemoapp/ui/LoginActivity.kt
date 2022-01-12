package com.example.tvdemoapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope

import com.example.tvdemoapp.R
import com.example.tvdemoapp.dataModel.LoginRequest
import com.example.tvdemoapp.dataModel.LoginResponse
import com.example.tvdemoapp.viewModel.AuthViewmodel


/**
 * Loads [MainFragment].
 */
class LoginActivity : FragmentActivity() {
    lateinit var viewModel: AuthViewmodel

    lateinit var otp_btn: Button
    lateinit var email_input: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        otp_btn = findViewById(R.id.otp_btn)
        email_input = findViewById(R.id.email_input)
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
                Toast.makeText(this@LoginActivity, "Successfully Create", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(AuthViewmodel::class.java)

    }
}

