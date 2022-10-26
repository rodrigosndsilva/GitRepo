package com.rodrigosnds.gitrepo.ui.homescreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.rodrigosnds.gitrepo.R
import com.rodrigosnds.gitrepo.ui.components.DefaultCard
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
                    DefaultCard(
                        onItemClick = {
                            navigator.navigate(
                                RepoDetailsDestination(repo.owner.ownerName, repo.name),
                                onlyIfResumed = true
                            )
                        },
                        content = {
                            Box(
                                modifier = Modifier
                                    .padding(15.dp)
                                    .padding(top = 10.dp, bottom = 10.dp)
                            ) {
                                Column(
                                    modifier = Modifier.padding(15.dp)
                                ) {
                                    Row(
                                        Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.Start
                                    )
                                    {
                                        Icon(
                                            painter = painterResource(id = R.drawable.github_user),
                                            contentDescription = stringResource(id = R.string.content_description_user_icon)
                                        )
                                        Text(
                                            text = repo.name,
                                            style = MaterialTheme.typography.body1,
                                            overflow = TextOverflow.Ellipsis,
                                            modifier = Modifier.padding(start = 5.dp)
                                        )
                                    }
                                    Spacer(modifier = Modifier.padding(10.dp))
                                    Row(
                                        Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.Start
                                    )
                                    {
                                        Icon(
                                            painter = painterResource(id = R.drawable.github_description),
                                            contentDescription = stringResource(id = R.string.content_description_icon)
                                        )
                                        Text(
                                            text = repo.description
                                                ?: stringResource(id = R.string.no_description),
                                            style = MaterialTheme.typography.body1,
                                            overflow = TextOverflow.Ellipsis,
                                            modifier = Modifier.padding(start = 5.dp)
                                        )
                                    }
                                    Spacer(modifier = Modifier.padding(10.dp))
                                    Row(
                                        Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.Start
                                    )
                                    {
                                        Icon(
                                            painter = painterResource(id = R.drawable.github_stars),
                                            contentDescription = stringResource(id = R.string.content_description_stars_icon)
                                        )
                                        Text(
                                            text = "${repo.stargazersCount}",
                                            style = MaterialTheme.typography.body1,
                                            overflow = TextOverflow.Ellipsis,
                                            modifier = Modifier.padding(start = 5.dp)
                                        )
                                    }
                                }
                            }
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