package com.rodrigosnds.gitrepo.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rodrigosnds.gitrepo.domain.model.Repository

@Composable
fun RepoDetailCard(
    repo: Repository,
) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(50.dp)
            .height(500.dp)
            .width(500.dp)
    ) {
        Text(text = repo.name)
    }
}