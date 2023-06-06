package com.example.painthings.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Calendar

@Parcelize
data class HomeDate(
    var cal: Calendar? = null,
    var isClicked: Boolean = false
) : Parcelable