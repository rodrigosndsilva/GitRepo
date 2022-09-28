package com.rodrigosnds.gitrepo.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rodrigosnds.gitrepo.domain.model.Repository

@Composable
fun RepoListItem(
    repo: Repository,
    onItemClick: (Repository) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { },
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CardRepo(repo = repo)
    }
}





