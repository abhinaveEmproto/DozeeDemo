package com.example.tvdemoapp.network

import com.example.tvdemoapp.dataModel.LoginRequest
import com.example.tvdemoapp.dataModel.LoginResponse
import com.example.tvdemoapp.dataModel.OtpRequest
import com.example.tvdemoapp.dataModel.OtpResponse
import retrofit2.Response
import retrofit2.http.*

interface RetroService {
    @POST("otp/request")
    @Headers("x-sens-api-key:222617e07f6e1dba002a611b77135548","x-sens-api-key-id: 25b0814e-754e-4f63-b4b3-cb663ad1341c")
    suspend fun getSessionId(@Body loginBody:LoginRequest): Response<LoginResponse>

    @POST("otp/verify?category=OPERATOR")
    @Headers("x-sens-api-key:222617e07f6e1dba002a611b77135548","x-sens-api-key-id: 25b0814e-754e-4f63-b4b3-cb663ad1341c")
    suspend fun submitOtp(@Body otpRequest: OtpRequest) :Response<OtpResponse>

}