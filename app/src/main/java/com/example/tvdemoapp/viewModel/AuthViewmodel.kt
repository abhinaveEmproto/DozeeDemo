package com.example.tvdemoapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tvdemoapp.dataModel.LoginRequest
import com.example.tvdemoapp.dataModel.LoginResponse
import com.example.tvdemoapp.dataModel.OtpRequest
import com.example.tvdemoapp.dataModel.OtpResponse
import com.example.tvdemoapp.network.RetroInstance
import com.example.tvdemoapp.network.RetroService
import kotlinx.coroutines.launch
import java.lang.Exception

class AuthViewmodel : ViewModel() {

    lateinit var mService: RetroService
    val loginResponse = MutableLiveData<LoginResponse>()
    val otpResponse=MutableLiveData<OtpResponse>()

    fun getSessionId(body: LoginRequest): LiveData<LoginResponse> {

        viewModelScope.launch {
            try {
                mService = RetroInstance.getRetroInstance().create(RetroService::class.java)
                val api = mService.getSessionId(body)
                if (api.isSuccessful) {
                    loginResponse.value = api.body()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return loginResponse

    }

    fun submitOtp(body: OtpRequest):LiveData<OtpResponse>{
        viewModelScope.launch {
            try {
               mService=RetroInstance.getRetroInstance().create(RetroService::class.java)
                val api=mService.submitOtp(body)
                if (api.isSuccessful && !api.toString().isNullOrEmpty()){
                    otpResponse.value=api.body()
                }
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
        return otpResponse
    }

   /* fun getLoginResponseObserver():MutableLiveData<LoginResponse>{
    return loginResponse
    }*/
//    fun loginResponse()
}
