package com.example.fetchrewardsandroidtakehome.services

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    private const val URL = "https://fetch-hiring.s3.amazonaws.com/hiring.json"

    private val okHttp = OkHttpClient.Builder()

    //retrofit builder
    private val builder =Retrofit.Builder().baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp.build())

    //create retrofit Instance
    private val retrofit = builder.build()

    fun <T> buildService (serviceType :Class<T>):T{
        return retrofit.create(serviceType)
    }
}