package com.rodrigosnds.gitrepo.common

import android.util.Log
import com.rodrigosnds.gitrepo.BuildConfig
import com.rodrigosnds.gitrepo.data.remote.GitRepoApi
import com.rodrigosnds.gitrepo.data.repository.GitRepoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun gitRepoApi(): GitRepoApi {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.URL_GITHUB)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GitRepoApi::class.java)
    }

    @Provides
    @Singleton
    fun gitRepoRepository(api: GitRepoApi): GitRepoRepository {
        return GitRepoRepository(api)
    }
}
