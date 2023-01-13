package com.geektech.countryapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.geektech.countryapp.core.Resource
import com.geektech.countryapp.data.network.RetrofitClient
import com.geektech.countryapp.model.Country
import kotlinx.coroutines.Dispatchers

class Repository {
    fun getCountries(): LiveData<Resource<Country?>> = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val result = RetrofitClient.api.getCountries()
        if (result.isSuccessful) {
            Log.e("ololo", "getCountries: " + result.body().toString())
            emit(Resource.success(result.body()))
        } else {
            Log.e("ololo", "getCountries: " + result.message())
        }
    }
}