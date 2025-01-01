package com.example.plantdiseasedetector.presentation.authentication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.plantdiseasedetector.data.network.SignUpResponse
import com.example.plantdiseasedetector.data.network.UserRepository
import com.example.plantdiseasedetector.data.network.VerifyResponse
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SignUpViewModel(private val repository: UserRepository) : ViewModel() {

    fun signUp(name: String, phone: String, onResult: (Boolean, String) -> Unit) {
        viewModelScope.launch {
            repository.signUp(name, phone).enqueue(object : Callback<SignUpResponse> {
                override fun onResponse(call: Call<SignUpResponse>, response: Response<SignUpResponse>) {
                    if (response.isSuccessful) {
                        val message = response.body()?.message ?: "Sign-up successful!"
                        onResult(true, message)
                    } else {
                        onResult(false, "Sign-up failed!")
                    }
                }

                override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                    onResult(false, t.message ?: "An error occurred")
               }
            })
        }
    }

    fun verify(phone: String, code: String, onResult: (Boolean, String) -> Unit) {
        viewModelScope.launch {
            repository.verify(phone, code).enqueue(object : Callback<VerifyResponse> {
                override fun onResponse(
                    call: Call<VerifyResponse>,
                    response: Response<VerifyResponse>
                ) {
                    if (response.isSuccessful) {
                        val message = response.body()?.message ?: "Verification successful!"
                        onResult(true, message)
                    } else {
                        onResult(false, "Verification failed!")
                    }
                }

                override fun onFailure(call: Call<VerifyResponse>, t: Throwable) {
                    onResult(false, t.message ?: "An error occurred")
                }
            })
        }
    }
}

