package com.rodrigosnds.gitrepo.domain.model


import com.google.gson.annotations.SerializedName

data class Owner(
    @SerializedName("login")
    val ownerName: String,
)