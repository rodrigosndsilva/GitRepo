package com.rodrigosnds.gitrepo.ui.repo_details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.rodrigosnds.gitrepo.R
import com.rodrigosnds.gitrepo.ui.components.RepoDetailCard
import com.rodrigosnds.gitrepo.ui.destinations.HomescreenDestination

@Destination(
    navArgsDelegate = RepoDetailsNavArgs::class
)
@Composable
fun RepoDetails(
    navigator: DestinationsNavigator,
    viewModel: RepoDetailsViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    Column(
        modifier = Modifier
            .padding(top = 10.dp, start = 15.dp, end = 15.dp, bottom = 50.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_back_btn),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(20.dp)
                .clip(RoundedCornerShape(100))
                .clickable { navigator.navigate(HomescreenDestination) }
        )
        Spacer(modifier = Modifier.padding(10.dp))
        state.repoDetail?.let { RepoDetailCard(repo = it) }
    }
}