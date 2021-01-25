package com.dean.tombasinproject.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Tumbasin(
    var name: String? = null,
    var price: String? = null,
    var image: Int? = null

) : Parcelable