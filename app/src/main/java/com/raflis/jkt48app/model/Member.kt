package com.raflis.jkt48app.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Member(
    val name: String,
    val dateOfBirth: String,
    var bloodGroup: String = "O",
    val height: Int,
    val gen: Int,
    val profilePicture: String,
    ) : Parcelable
