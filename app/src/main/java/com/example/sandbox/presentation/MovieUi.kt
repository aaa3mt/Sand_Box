package com.example.sandbox.presentation

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieUi(
    val rating: Double,
    val title: String,
    val description: String = "No description yet",
    val imageUrl: String = "https://pbs.twimg.com/media/EeGYe1aUYAEYOiA.png"
): Parcelable