package com.rodrigosnds.gitrepo.ui.homescreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodrigosnds.gitrepo.domain.use_cases.ListRepos
import com.rodrigosnds.gitrepo.domain.use_cases.ListUserRepos
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomescreenViewModel @Inject constructor(
    private val listRepos: ListRepos,
    private val listUserRepos: ListUserRepos,
) : ViewModel() {

    private val _state = MutableStateFlow(HomescreenState())
    val state = _state.asStateFlow()

    fun getListRepos(name: String, sort: String, order: String) = viewModelScope.launch {
        _state.update { it.copy(isLoading = true) }
        runCatching { listRepos(name, sort, order) }
            .onSuccess { repo ->
                _state.update { it.copy(repoList =  repo.repositoryList) }
            }
            .onFailure { error ->
                _state.update { it.copy(error = error.message) }
            }
        _state.update { it.copy(isLoading = false) }
    }

    fun getListUsers(user: String)  = viewModelScope.launch {
        _state.update { it.copy(isLoading = true) }
        runCatching { listUserRepos(user) }
            .onSuccess { repo ->
                _state.update { it.copy(repoList =  repo) }
            }
            .onFailure { error ->
                _state.update { it.copy(error = error.message) }
            }
        _state.update { it.copy(isLoading = false) }
    }
}