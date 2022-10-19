package com.rodrigosnds.gitrepo.domain.model


import com.google.gson.annotations.SerializedName

data class Repository(
    val description: String,
    val id: Int,
    val language: String,
    val name: String,
    val owner: Owner,
    val stargazersCount: Int,
    val stargazersUrl: String
)