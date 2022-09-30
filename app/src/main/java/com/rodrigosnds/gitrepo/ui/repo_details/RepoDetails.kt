package com.rodrigosnds.gitrepo.ui.repo_details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.rodrigosnds.gitrepo.ui.components.RepoDetailCard

@Destination(
    navArgsDelegate = RepoDetailsNavArgs::class

)
@Composable
fun RepoDetails(
    viewModel: RepoDetailsViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    Column(
        modifier = Modifier
            .padding(top = 10.dp, start = 15.dp, end = 15.dp, bottom = 50.dp)
    ) {
        state.repoDetail?.let { RepoDetailCard(repo = it) }
    }
}