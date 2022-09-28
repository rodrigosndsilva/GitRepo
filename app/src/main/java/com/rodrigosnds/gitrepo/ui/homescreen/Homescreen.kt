package com.rodrigosnds.gitrepo.ui.homescreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.rodrigosnds.gitrepo.ui.components.RepoListItem
import com.rodrigosnds.gitrepo.ui.components.UserRepoNavbar

@Composable
fun Homescreen(
    //navController: NavController,
    viewModel: HomescreenViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    Column() {
        Button(onClick = { /*TODO*/ }) {}
        UserRepoNavbar(viewModel)
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.repoList) { repo ->
                    RepoListItem(
                        repo = repo,
                        onItemClick = {
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
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}