package com.rodrigosnds.gitrepo.ui.homescreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodrigosnds.gitrepo.common.Constants
import com.rodrigosnds.gitrepo.common.Resource
import com.rodrigosnds.gitrepo.domain.model.Repository
import com.rodrigosnds.gitrepo.domain.use_cases.GetListOfRepos
import com.rodrigosnds.gitrepo.domain.use_cases.GetListOfUsers
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomescreenViewModel @Inject constructor(
    private val getListOfRepos: GetListOfRepos,
    private val getListOfUsers: GetListOfUsers
) : ViewModel() {

    private val _state = mutableStateOf(RepositoryListState())
    val state: State<RepositoryListState> = _state

    init {
        //getListRepos(Constants.PARAM_NAME, Constants.PARAM_SORT, Constants.PARAM_ORDER)
    }

    fun getListRepos(name: String, sort: String, order: String) {
        getListOfRepos(name, sort, order).onEach { result ->
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

    fun getListUsers(user: String) {
        getListOfUsers(user).onEach { result ->
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