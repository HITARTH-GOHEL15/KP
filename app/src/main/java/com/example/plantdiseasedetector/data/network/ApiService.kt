package com.example.plantdiseasedetector.data.network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

// Request and Response Models
data class SignUpRequest(val name: String, val phone: String)
data class SignUpResponse(val message: String, val error: String?)
data class VerifyRequest(val phone: String, val code: String)
data class VerifyResponse(val message: String, val error: String?)

// Retrofit API Interface
interface ApiService {
    @POST("/signup")
    fun signUp(@Body request: SignUpRequest): Call<SignUpResponse>

    @POST("/verify")
    fun verify(@Body request: VerifyRequest): Call<VerifyResponse>
}
