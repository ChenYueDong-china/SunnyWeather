package com.heyingguai.sunnyweather.login.network

import com.heyingguai.sunnyweather.SunnyWeatherApplication
import com.heyingguai.sunnyweather.login.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceService {

    @GET("v2/place?token=${SunnyWeatherApplication.TOKEN}&lang=zh_CN")
    fun searchPlaces(@Query("query") query: String):Call<PlaceResponse>
}