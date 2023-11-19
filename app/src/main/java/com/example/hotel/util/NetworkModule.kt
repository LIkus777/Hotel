package com.example.hotel.util

import com.example.hotel.api.ApiService
import com.example.hotel.api.BASE_URL
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        OkHttpClient.Builder().build()
    }
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .client(get())
            .build()
    }
    single { get<Retrofit>().create(ApiService::class.java) }
}
