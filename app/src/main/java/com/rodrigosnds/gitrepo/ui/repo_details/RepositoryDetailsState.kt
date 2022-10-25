package com.rodrigosnds.gitrepo.ui.repo_details

import com.rodrigosnds.gitrepo.domain.model.Repository

data class RepositoryDetailsState(
    val isLoading: Boolean = false,
    val repoDetail: Repository? = null,
    val error: String? = null
)