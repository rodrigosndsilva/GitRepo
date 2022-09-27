package com.rodrigosnds.gitrepo.domain.model

import com.google.gson.annotations.SerializedName

class ListRepository(
    @SerializedName("items")
    val repositoryList: List<Repository>
)