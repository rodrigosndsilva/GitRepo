package com.rodrigosnds.gitrepo.data.remote

import com.rodrigosnds.gitrepo.domain.model.ListRepository
import com.rodrigosnds.gitrepo.domain.model.Repository
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitRepoApi {
    @GET("search/repositories")
    suspend fun getListOfRepos(
        @Query("q") name: String,
        @Query("sort") sort: String,
        @Query("order") order: String
    ): ListRepository

    @GET("users/{users}/repos")
    suspend fun getListOfUsers(@Path("users") users: String): List<Repository>
}