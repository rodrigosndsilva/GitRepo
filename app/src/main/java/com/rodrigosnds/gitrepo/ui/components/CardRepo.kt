package com.rodrigosnds.gitrepo.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.rodrigosnds.gitrepo.R
import com.rodrigosnds.gitrepo.domain.model.Repository


@Composable
fun CardRepo(
    repo: Repository,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        shape = RoundedCornerShape(15),
        elevation = 20.dp
    )
    {
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
                        text = repo.description ?: stringResource(id = R.string.no_description),
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
}