package com.rodrigosnds.gitrepo.common

import com.rodrigosnds.gitrepo.BuildConfig
import com.rodrigosnds.gitrepo.data.remote.GitRepoService
import com.rodrigosnds.gitrepo.data.repository.GitRepoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun gitRepoApi(): GitRepoService {
        val httpClient = OkHttpClient.Builder().addLoggingInterceptor().build()
        return Retrofit.Builder()
            .baseUrl(BuildConfig.URL_GITHUB)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
            .create(GitRepoService::class.java)
    }

    @Provides
    @Singleton
    fun gitRepoRepository(api: GitRepoService): GitRepoRepository {
        return GitRepoRepository(api)
    }

    private fun OkHttpClient.Builder.addLoggingInterceptor(): OkHttpClient.Builder {
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            this.addInterceptor(loggingInterceptor)
        }
        return this
    }
}
