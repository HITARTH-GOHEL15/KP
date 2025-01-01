package com.example.plantdiseasedetector.data.network

class UserRepository {
    private val apiService = RetrofitClient.instance.create(ApiService::class.java)

    fun signUp(name: String, phone: String) = apiService.signUp(SignUpRequest(name, phone))
    fun verify(phone: String, code: String) = apiService.verify(VerifyRequest(phone , code))

}