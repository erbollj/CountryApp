package com.geektech.countryapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Translations(
    val br: String,
    val de: String,
    val es: String,
    val fa: String,
    val fr: String,
    val hr: String,
    val hu: String,
    val `it`: String,
    val ja: String,
    val nl: String,
    val pt: String
): Parcelable