package com.example.tvdemoapp.viewModel

import android.provider.LiveFolders
import androidx.lifecycle.LiveData

interface AuthListener {
    fun onStarted()
    fun onSuccess(LoginResponse:LiveData<String>)
    fun onFailure(message:String)
}