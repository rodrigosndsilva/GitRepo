package com.rodrigosnds.gitrepo.data.remote

import com.rodrigosnds.gitrepo.domain.model.Repository
import com.rodrigosnds.gitrepo.domain.model.RepositoryList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitRepoService {
    @GET("search/repositories")
    suspend fun listRepos(
        @Query("q") name: String,
        @Query("sort") sort: String,
        @Query("order") order: String,
    ): RepositoryList

    @GET("users/{users}/repos")
    suspend fun listUserRepos(@Path("users") users: String): List<Repository>

    @GET("/repos/{owner}/{repo}")
    suspend fun listRepoDetails(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
    ): Repository
}