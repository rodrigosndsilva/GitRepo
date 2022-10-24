package com.rodrigosnds.gitrepo.data.repository

import com.rodrigosnds.gitrepo.data.remote.GitRepoService
import javax.inject.Inject

class GitRepoRepository @Inject constructor(private val gitRepoService: GitRepoService) {

    suspend fun listRepos(name: String, sort: String, order: String) =
        gitRepoService.listRepos(name, sort, order)

    suspend fun listUserRepos(user: String) = gitRepoService.listUserRepos(user)

    suspend fun listRepoDetails(owner: String, repo: String) =
        gitRepoService.listRepoDetails(owner, repo)
}