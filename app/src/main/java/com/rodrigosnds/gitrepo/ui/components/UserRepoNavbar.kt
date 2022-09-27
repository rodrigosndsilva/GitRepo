package com.rodrigosnds.gitrepo.ui.components

import android.widget.Space
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rodrigosnds.gitrepo.ui.homescreen.HomescreenViewModel

@Composable
fun UserRepoNavbar(viewModel: HomescreenViewModel) {
    val selectedUsers = remember { mutableStateOf(true) }
    val selectedRepos = remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .padding(15.dp)
    ) {
        Button(modifier = Modifier
            .weight(1.0f),
            contentPadding = PaddingValues(
                start = 20.dp,
                top = 12.dp,
                end = 20.dp,
                bottom = 12.dp
            ),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = if (selectedUsers.value) Color.Blue else Color.Gray
            ),
            onClick = {
                if (!selectedUsers.value) {
                    selectedUsers.value = !selectedUsers.value
                    selectedRepos.value = !selectedRepos.value
                }
            })
        {
            Text(text = "Users")
        }

        Spacer(modifier = Modifier.padding(5.dp))

        Button(modifier = Modifier
            .weight(1.0f),
            contentPadding = PaddingValues(
                start = 20.dp,
                top = 12.dp,
                end = 20.dp,
                bottom = 12.dp
            ),
            colors = ButtonDefaults.buttonColors(
            backgroundColor = if (selectedRepos.value) Color.Blue else Color.Gray
            ),
            onClick = {
                if (!selectedRepos.value) {
                    selectedRepos.value = !selectedRepos.value
                    selectedUsers.value = !selectedUsers.value
                }
                viewModel.getListUsers("RafaelBelo14")
            }) {
            Text(text = "Repos")
        }
    }
}