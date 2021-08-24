package com.swapnil.gitapp.network


import com.swapnil.gitapp.model.User
import retrofit2.Call
import retrofit2.http.GET

interface GitApi {
    @GET("users/swapnil20711")
    fun getUser(): Call<User>
}