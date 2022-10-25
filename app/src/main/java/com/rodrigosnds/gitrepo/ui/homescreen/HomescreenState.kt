package com.rodrigosnds.gitrepo.ui.homescreen

import com.rodrigosnds.gitrepo.domain.model.Repository

data class HomescreenState(
    val isLoading: Boolean = false,
    val repoList: List<Repository> = emptyList(),
    val error: String? = null
)