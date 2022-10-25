package com.rodrigosnds.gitrepo.ui.homescreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodrigosnds.gitrepo.common.Resource
import com.rodrigosnds.gitrepo.domain.model.Repository
import com.rodrigosnds.gitrepo.domain.use_cases.ListRepos
import com.rodrigosnds.gitrepo.domain.use_cases.ListUserRepos
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomescreenViewModel @Inject constructor(
    private val listRepos: ListRepos,
    private val listUserRepos: ListUserRepos,
) : ViewModel() {

    private val _state = MutableStateFlow(RepositoryListState())
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

    fun getListUsers(user: String) {
        listUserRepos(user).onEach { result ->
            when (result) {
                is Resource.Success<List<Repository>> -> {
                    _state.value = RepositoryListState(repoList = result.data ?: emptyList())
                }
                is Resource.Loading<List<Repository>> -> {
                    _state.value = RepositoryListState(isLoading = true)
                }
                is Resource.Error<List<Repository>> -> {
                    _state.value = RepositoryListState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }

            }
        }.launchIn(viewModelScope)
    }
}