package com.heyingguai.sunnyweather.ui.place

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.heyingguai.sunnyweather.login.Repository
import com.heyingguai.sunnyweather.login.dao.PlaceDao
import com.heyingguai.sunnyweather.login.model.Place

class PlaceViewModel : ViewModel() {
    private val searchLiveData = MutableLiveData<String>()
    fun savePlace(place: Place) =
        Repository.savePlace(place)


    fun getSavedPlace() = Repository.getSavedPlace()
    fun isPlaceSaved() = Repository.isPlaceSaved()

    fun searchPlaces(query: String) {
        Log.i("TAG", "searchPlaces: "+query)
        searchLiveData.value = query

    }


    val placeList = ArrayList<Place>()

    val placeLiveData = Transformations.switchMap(searchLiveData) { query ->
        Repository.searchPlaces(query).asLiveData()
    }
}