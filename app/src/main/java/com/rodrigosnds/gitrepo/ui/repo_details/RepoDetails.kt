package com.rodrigosnds.gitrepo.ui.repo_details

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.rodrigosnds.gitrepo.ui.components.CardRepo

@Destination
@Composable
fun RepoDetails(
    viewModel: RepoDetailsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    state.repoDetail?.let { CardRepo(repo = it) }
}