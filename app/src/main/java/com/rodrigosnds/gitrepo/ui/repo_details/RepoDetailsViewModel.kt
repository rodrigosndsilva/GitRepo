package com.rodrigosnds.gitrepo.ui.repo_details

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodrigosnds.gitrepo.common.Constants
import com.rodrigosnds.gitrepo.common.Resource
import com.rodrigosnds.gitrepo.domain.model.SpecificRepository
import com.rodrigosnds.gitrepo.domain.use_cases.GetRepoByID
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RepoDetailsViewModel @Inject constructor(
    private val getRepoByID: GetRepoByID,
) : ViewModel() {

    private val _state = mutableStateOf(RepositoryDetailsState())
    val state: MutableState<RepositoryDetailsState> = _state

    init {

    }

    private fun getRepoById(id: String) {
        getRepoByID(id.toInt()).onEach { result ->
            when (result) {
                is Resource.Success<SpecificRepository> -> {
                    _state.value = RepositoryDetailsState(repoDetail = result.data)
                }
                is Resource.Loading<SpecificRepository> -> {
                    _state.value = RepositoryDetailsState(isLoading = true)
                }
                is Resource.Error<SpecificRepository> -> {
                    _state.value = RepositoryDetailsState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }

            }
        }.launchIn(viewModelScope)
    }
}