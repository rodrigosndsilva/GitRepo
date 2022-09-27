package com.rodrigosnds.gitrepo.ui.homescreen

import com.rodrigosnds.gitrepo.domain.model.Repository

data class RepositoryListState(
    val isLoading: Boolean = false,
    val repoList: List<Repository> = emptyList(),
    val error: String = ""
)