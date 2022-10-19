package com.rodrigosnds.gitrepo.ui.homescreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.rodrigosnds.gitrepo.ui.components.RepoListItem
import com.rodrigosnds.gitrepo.ui.components.UserRepoNavbar
import com.rodrigosnds.gitrepo.ui.destinations.RepoDetailsDestination

@Destination(
    start = true
)
@Composable
fun Homescreen(
    navigator: DestinationsNavigator,
    viewModel: HomescreenViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    Column {
        UserRepoNavbar(viewModel)
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.repoList) { repo ->
                    RepoListItem(
                        repo = repo,
                        onItemClick = {
                            navigator.navigate(
                                RepoDetailsDestination(repo.owner.ownerName, repo.name),
                                onlyIfResumed = true
                            )
                        }
                    )
                }
            }
            if (state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Center)
                )
            }
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}