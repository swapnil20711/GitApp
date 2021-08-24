package com.swapnil.gitapp.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {
    /**
     * Build the Moshi object with Kotlin adapter factory that Retrofit will be using.
     */
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
    private fun getRetrofit():Retrofit{
        return   Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl("https://api.github.com/")
            .build()
    }
    val gitApi: GitApi = getRetrofit().create(GitApi::class.java)
}