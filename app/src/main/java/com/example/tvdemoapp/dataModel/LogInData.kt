package com.example.tvdemoapp.dataModel

data class LoginRequest(val Medium:String, val MediumValue:String)
data class LoginResponse(val SessionId:String)

data class OtpRequest(val Medium: String, val MediumValue: String, val SessionId: String, val Otp:String)

data class OtpResponse(val AuthToken:String)
