package com.rodrigosnds.gitrepo.domain.model

data class Repository(
    val description: String?,
    val id: Int,
    val language: String,
    val name: String,
    val owner: Owner,
    val stargazersCount: Int,
    val stargazersUrl: String
)