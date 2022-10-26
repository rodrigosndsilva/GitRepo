package com.rodrigosnds.gitrepo.ui.homescreen

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodrigosnds.gitrepo.R
import com.rodrigosnds.gitrepo.domain.use_cases.ListRepos
import com.rodrigosnds.gitrepo.domain.use_cases.ListUserRepos
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

const val PARAM_SORT = "stars"
const val PARAM_ORDER = "desc"

@HiltViewModel
class HomescreenViewModel @Inject constructor(
    private val listRepos: ListRepos,
    private val listUserRepos: ListUserRepos,
) : ViewModel() {

    private val _state = MutableStateFlow(HomescreenState())
    val state = _state.asStateFlow()

    fun getPlaceholder() =
        if (state.value.tabState == TabState.USER) R.string.input_user_name_label
        else R.string.input_repo_name_label

    fun switchedToUserTab() {
        if (state.value.tabState == TabState.REPO)
            _state.update { it.copy(tabState = TabState.USER) }
    }

    fun switchedToRepoTab() {
        if (state.value.tabState == TabState.USER)
            _state.update { it.copy(tabState = TabState.REPO) }
    }

    fun getBackgroundColorForUserBtn() =
        if (state.value.tabState == TabState.USER)
            Color.Blue else Color.Gray

    fun getBackgroundColorForRepoBtn() =
        if (state.value.tabState == TabState.REPO)
            Color.Blue else Color.Gray

    fun onResearch(outlinedText: String) {
        if (state.value.tabState == TabState.USER)
            getListUsers(outlinedText)
        else
            getListRepos(outlinedText.trim())
    }

    private fun getListRepos(name: String) = viewModelScope.launch {
        _state.update { it.copy(isLoading = true, repoList = emptyList(), error = null) }
        runCatching { listRepos(name, PARAM_SORT, PARAM_ORDER) }
            .onSuccess { repo ->
                _state.update { it.copy(repoList = repo.repositoryList, error = null) }
            }
            .onFailure { error ->
                _state.update { it.copy(repoList = emptyList(), error = error.message) }
            }
        _state.update { it.copy(isLoading = false) }
    }

    private fun getListUsers(user: String) = viewModelScope.launch {
        _state.update { it.copy(isLoading = true, repoList = emptyList(), error = null) }
        runCatching { listUserRepos(user) }
            .onSuccess { repoList ->
                _state.update { it.copy(repoList = repoList, error = null) }
            }
            .onFailure { error ->
                _state.update { it.copy(repoList = emptyList(), error = error.message) }
            }
        _state.update { it.copy(isLoading = false) }
    }
}