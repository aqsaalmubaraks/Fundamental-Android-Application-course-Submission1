package com.example.githubuser

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Suppress("DEPRECATED_ANNOTATION")
@Parcelize
data class User (
    var avatar: Int,
    var name: String,
    var username: String,
    var follower: String,
    var following: String,
    var repo: String,
    var company: String,
    var location : String
    ):Parcelable
