package com.rodrigosnds.gitrepo.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.rodrigosnds.gitrepo.domain.model.Repository

@Composable
fun RepoListItem(
    repo: Repository,
    onItemClick: (Repository) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(repo) },
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        CardRepo(repo)
    }
}





