package com.rodrigosnds.gitrepo.ui.repo_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodrigosnds.gitrepo.domain.use_cases.ListRepoDetails
import com.rodrigosnds.gitrepo.ui.destinations.RepoDetailsDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepoDetailsViewModel @Inject constructor(
    private val listRepoDetails: ListRepoDetails,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = MutableStateFlow(RepositoryDetailsState())
    val state = _state.asStateFlow()

    init {
        val navArgs: RepoDetailsNavArgs = RepoDetailsDestination.argsFrom(savedStateHandle)
        getListRepoDetails(navArgs.repoOwner, navArgs.repoName)
    }

    private fun getListRepoDetails(owner: String, repo: String) = viewModelScope.launch {
        _state.update { it.copy(isLoading = true) }
        runCatching { listRepoDetails(owner, repo) }
            .onSuccess { repo ->
                _state.update { it.copy(repoDetail = repo) }
            }
            .onFailure { error ->
                _state.update { it.copy(error = error.message) }
            }
        _state.update { it.copy(isLoading = false) }
    }
}