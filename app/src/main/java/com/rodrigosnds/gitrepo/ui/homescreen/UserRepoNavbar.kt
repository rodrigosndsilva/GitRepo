package com.rodrigosnds.gitrepo.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.rodrigosnds.gitrepo.R
import com.rodrigosnds.gitrepo.ui.homescreen.HomescreenViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun UserRepoNavbar(viewModel: HomescreenViewModel) {

    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    var outlinedText by remember { mutableStateOf("") }

    Column {
        Row(
            modifier = Modifier
                .padding(
                    start = 20.dp,
                    top = 25.dp,
                    end = 20.dp,
                    bottom = 12.dp,
                )
                .align(alignment = Alignment.CenterHorizontally)

        ) {
            OutlinedTextField(
                modifier = Modifier
                    .width(240.dp)
                    .height(60.dp),
                shape = RoundedCornerShape(50),
                value = outlinedText,
                label = { Text(text = stringResource(id = viewModel.getPlaceholder())) },
                onValueChange = {
                    outlinedText = it
                }
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Button(modifier = Modifier
                .height(50.dp)
                .align(alignment = Alignment.CenterVertically),
                shape = RoundedCornerShape(100),
                onClick = {
                    viewModel.onResearch(outlinedText)
                    keyboardController?.hide()
                    focusManager.clearFocus()
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
                    backgroundColor = viewModel.getBackgroundColorForUserBtn(),
                    contentColor = Color.White
                ),
                onClick = { viewModel.switchedToUserTab() })
            {
                Text(text = stringResource(id = R.string.btn_user_name))
            }

            Spacer(modifier = Modifier.padding(5.dp))

            Button(
                modifier = Modifier
                    .weight(1.0f),
                contentPadding = PaddingValues(
                    start = 20.dp,
                    top = 12.dp,
                    end = 20.dp,
                    bottom = 12.dp
                ),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = viewModel.getBackgroundColorForRepoBtn(),
                    contentColor = Color.White,
                ),
                onClick = { viewModel.switchedToRepoTab() }
            ) {
                Text(text = stringResource(id = R.string.btn_repo_name))
            }
        }
    }
}