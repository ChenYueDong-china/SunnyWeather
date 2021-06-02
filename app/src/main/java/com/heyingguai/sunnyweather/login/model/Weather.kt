package com.heyingguai.sunnyweather.login.model

data class Weather(val realTime: RealtimeResponse.RealTime, val daily: DailyResponse.Daily) {
}