package com.rodrigosnds.gitrepo.data.repository

import com.rodrigosnds.gitrepo.data.remote.GitRepoApi
import com.rodrigosnds.gitrepo.domain.model.ListRepository
import com.rodrigosnds.gitrepo.domain.model.Repository
import javax.inject.Inject

class GitRepoRepository @Inject constructor(
    private val api: GitRepoApi
) {
    suspend fun getListOfRepos(name: String, sort: String, order: String): ListRepository {
        return api.getListOfRepos(name, sort, order)
    }

    suspend fun getListOfUsers(user: String): ListRepository {
        return api.getListOfUsers(user)
    }
}