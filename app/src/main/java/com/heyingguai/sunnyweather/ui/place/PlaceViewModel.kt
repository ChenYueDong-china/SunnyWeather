package com.heyingguai.sunnyweather.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.heyingguai.sunnyweather.login.Repository
import com.heyingguai.sunnyweather.login.model.Place

class PlaceViewModel : ViewModel() {
    private val searchLiveData = MutableLiveData<String>()
    fun searchPlaces(query: String) {
        searchLiveData.value = query

    }


    val placeList = ArrayList<Place>()

    val placeLiveData = Transformations.switchMap(searchLiveData) { query ->
        Repository.searchPlaces(query).asLiveData()
    }
}