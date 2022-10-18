package com.rodrigosnds.gitrepo.data.remote

import com.rodrigosnds.gitrepo.domain.model.ListRepository
import com.rodrigosnds.gitrepo.domain.model.Repository
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitRepoApi {
    @GET("search/repositories")
    suspend fun listRepos(
        @Query("q") name: String,
        @Query("sort") sort: String,
        @Query("order") order: String
    ): ListRepository

    @GET("users/{users}/repos")
    suspend fun listUserRepos(@Path("users") users: String): List<Repository>

    @GET("/repos/{owner}/{repo}")
    suspend fun listRepoDetails(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Repository
}