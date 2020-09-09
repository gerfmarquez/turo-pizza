package com.maxor.turopizza.mvp.location

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LocationData(val timestamp: Long, val lat: Double,val lon: Double) : Parcelable