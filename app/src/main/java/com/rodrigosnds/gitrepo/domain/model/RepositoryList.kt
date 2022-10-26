package com.rodrigosnds.gitrepo.domain.model

import com.google.gson.annotations.SerializedName

class RepositoryList(
    @SerializedName("items")  val repositoryList: List<Repository>
)