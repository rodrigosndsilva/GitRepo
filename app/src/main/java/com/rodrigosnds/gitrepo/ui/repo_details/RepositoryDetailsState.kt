package com.rodrigosnds.gitrepo.ui.repo_details

import com.rodrigosnds.gitrepo.domain.model.SpecificRepository

data class RepositoryDetailsState(
    val isLoading: Boolean = false,
    val repoDetail: SpecificRepository? = null,
    val error: String = ""
)