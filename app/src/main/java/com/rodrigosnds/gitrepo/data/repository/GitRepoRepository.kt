package com.rodrigosnds.gitrepo.data.repository

import com.rodrigosnds.gitrepo.common.Resource
import com.rodrigosnds.gitrepo.data.remote.GitRepoApi
import com.rodrigosnds.gitrepo.domain.model.ListRepository
import com.rodrigosnds.gitrepo.domain.model.Repository
import retrofit2.HttpException
import javax.inject.Inject

class GitRepoRepository @Inject constructor(
    private val api: GitRepoApi
) {
    suspend fun listRepos(name: String, sort: String, order: String): ListRepository {
        return api.listRepos(name, sort, order)
    }

    suspend fun listUserRepos(user: String): List<Repository> {
        return api.listUserRepos(user)
    }

    suspend fun listRepoDetails(owner: String, repo: String): Repository {
        return api.listRepoDetails(owner, repo)
    }

}