package com.rodrigosnds.gitrepo.data.repository

import com.rodrigosnds.gitrepo.data.remote.GitRepoApi
import com.rodrigosnds.gitrepo.domain.model.ListRepository
import com.rodrigosnds.gitrepo.domain.model.Repository
import com.rodrigosnds.gitrepo.domain.model.SpecificRepository
import javax.inject.Inject

class GitRepoRepository @Inject constructor(
    private val api: GitRepoApi
) {
    suspend fun getRepos(name: String, sort: String, order: String): ListRepository {
        return api.getRepos(name, sort, order)
    }

    suspend fun getReposFromUser(user: String): List<Repository> {
        return api.getReposFromUser(user)
    }

    suspend fun getRepoByID(owner: String, repo: String): SpecificRepository {
        return api.getRepo(owner, repo)
    }
}