package com.geektech.countryapp.data.network

import com.geektech.countryapp.model.Country
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("v2/all")
    suspend fun getCountries(): Response<Country>
}