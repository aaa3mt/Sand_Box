package com.example.sandbox.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val rating: Double,
    val title: String,
    val description: String = "No description yet",
): Parcelable