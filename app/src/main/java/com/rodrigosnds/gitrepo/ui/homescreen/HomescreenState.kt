package com.rodrigosnds.gitrepo.ui.homescreen

import com.rodrigosnds.gitrepo.domain.model.Repository

enum class TabState {
    USER, REPO
}

data class HomescreenState(
    var tabState: TabState = TabState.USER,
    val isLoading: Boolean = false,
    val repoList: List<Repository> = emptyList(),
    val error: String? = null,
)