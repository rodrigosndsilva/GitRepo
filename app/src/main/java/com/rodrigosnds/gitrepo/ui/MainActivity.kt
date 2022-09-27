package com.rodrigosnds.gitrepo.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.rodrigosnds.gitrepo.ui.homescreen.Homescreen
import com.rodrigosnds.gitrepo.ui.theme.GitRepoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GitRepoTheme {
                Homescreen()
            }
        }
    }
}
