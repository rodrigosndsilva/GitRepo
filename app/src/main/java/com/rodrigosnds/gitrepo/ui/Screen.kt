package com.rodrigosnds.gitrepo.ui

sealed class Screen(val route: String) {
    object RepoListScreen : Screen("HomescreenViewModel")
    //object RepoDetailScreen : Screen("Repo_detail_screen")
}