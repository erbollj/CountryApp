package com.geektech.countryapp.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.geektech.countryapp.core.BaseViewModel
import com.geektech.countryapp.repository.Repository

class ListViewModel : BaseViewModel() {
    private val repo = Repository()

    private val _countries = MutableLiveData<Boolean>()
    val countries = _countries.switchMap {
        repo.getCountries()
    }

    fun getCountries() {
        _countries.postValue(true)
    }
}