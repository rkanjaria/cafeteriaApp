package com.example.cafeteria

import android.content.Context
import com.example.cafeteria.data.CafeteriaRepository
import com.example.cafeteria.data.remote.RetrofitApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Injection {

    private val BASE_URL = "someAPi.com/"

    private fun provideRetrofitApi(): RetrofitApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitApi::class.java)


    fun provideCafeteriaRepository(context: Context): CafeteriaRepository {
        return CafeteriaRepository.getInstance(provideRetrofitApi())
    }
}