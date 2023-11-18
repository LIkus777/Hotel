package com.example.hotel.util

import com.example.hotel.api.ApiService
import com.example.hotel.api.BASE_URL
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit

private const val CONVERTER_CONTENT_TYPE = "applicaiton/json"

val networkModule = module {
    single {
        OkHttpClient.Builder().build()
    }
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                Json { ignoreUnknownKeys = true }.asConverterFactory(
                    CONVERTER_CONTENT_TYPE.toMediaType()
                )
            )
            .client(get())
            .build()
    }
    single { get<Retrofit>().create(ApiService::class.java) }
}