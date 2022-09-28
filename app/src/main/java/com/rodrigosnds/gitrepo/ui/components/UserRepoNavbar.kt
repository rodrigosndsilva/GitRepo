package com.rodrigosnds.gitrepo.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.rodrigosnds.gitrepo.R
import com.rodrigosnds.gitrepo.common.Constants
import com.rodrigosnds.gitrepo.ui.homescreen.HomescreenViewModel

@Composable
fun UserRepoNavbar(viewModel: HomescreenViewModel) {
    val selectedUsers = remember { mutableStateOf(true) }
    val selectedRepos = remember { mutableStateOf(false) }
    var text by remember { mutableStateOf("") }
    var inputLabelText by remember { mutableStateOf(Constants.USER_NAME) }

    Column {
        Row(
            modifier = Modifier
                .padding(
                    start = 20.dp,
                    top = 25.dp,
                    end = 20.dp,
                    bottom = 12.dp
                )
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .width(280.dp),
                value = text,
                label = { Text(text = inputLabelText) },
                onValueChange = {
                    text = it
                }
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Button(modifier = Modifier
                .align(alignment = Alignment.CenterVertically),
                onClick = {
                    if (selectedUsers.value)
                        viewModel.getListUsers(text)
                    else
                        viewModel.getListRepos(
                            text,
                            Constants.PARAM_SORT,
                            Constants.PARAM_ORDER
                        )
                })
            {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = null
                )
            }
        }
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
                    backgroundColor = if (selectedUsers.value) Color.Blue else Color.Gray,
                    contentColor = Color.White
                ),
                onClick = {
                    if (!selectedUsers.value) {
                        selectedUsers.value = !selectedUsers.value
                        selectedRepos.value = !selectedRepos.value
                    }
                    inputLabelText = Constants.USER_NAME
                })
            {
                Text(text = Constants.BUTTON_USER_NAME)
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
                    backgroundColor = if (selectedRepos.value) Color.Blue else Color.Gray,
                    contentColor = Color.White
                ),
                onClick = {
                    if (!selectedRepos.value) {
                        selectedRepos.value = !selectedRepos.value
                        selectedUsers.value = !selectedUsers.value
                    }
                    inputLabelText = Constants.REPO_NAME
                }) {
                Text(text = Constants.BUTTON_REPO_NAME)
            }
        }
    }

}