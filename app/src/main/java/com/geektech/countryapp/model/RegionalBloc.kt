package com.geektech.countryapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RegionalBloc(
    val acronym: String,
    val name: String,
    val otherAcronyms: List<String>? = null,
    val otherNames: List<String>? = null
): Parcelable