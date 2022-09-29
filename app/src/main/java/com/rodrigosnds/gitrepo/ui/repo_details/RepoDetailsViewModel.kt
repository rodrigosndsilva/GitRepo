package com.rodrigosnds.gitrepo.ui.repo_details

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodrigosnds.gitrepo.common.Resource
import com.rodrigosnds.gitrepo.domain.model.Repository
import com.rodrigosnds.gitrepo.domain.use_cases.GetRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RepoDetailsViewModel @Inject constructor(
    private val getRepo: GetRepo,
) : ViewModel() {

    private val _state = mutableStateOf(RepositoryDetailsState())
    val state: MutableState<RepositoryDetailsState> = _state

    init {
        getRepoDetails("RafaelBelo14", "RafaelBelo14")
    }

    private fun getRepoDetails(owner: String, repo: String) {
        getRepo(owner, repo).onEach { result ->
            when (result) {
                is Resource.Success<Repository> -> {
                    _state.value = RepositoryDetailsState(repoDetail = result.data)
                }
                is Resource.Loading<Repository> -> {
                    _state.value = RepositoryDetailsState(isLoading = true)
                }
                is Resource.Error<Repository> -> {
                    _state.value = RepositoryDetailsState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }

            }
        }.launchIn(viewModelScope)
    }
}