package com.rodrigosnds.gitrepo.ui.homescreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
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
    val state by viewModel.state.collectAsState()
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
            state.error?.let {
                Text(
                    text = it,
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