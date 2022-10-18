package com.rodrigosnds.gitrepo.domain.use_cases

import com.rodrigosnds.gitrepo.common.Resource
import com.rodrigosnds.gitrepo.data.repository.GitRepoRepository
import com.rodrigosnds.gitrepo.domain.model.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ListRepoDetails @Inject constructor(
    private val repository: GitRepoRepository
) {
    operator fun invoke(
        owner: String,
        repo: String
    ): Flow<Resource<Repository>> = flow {
        try {
            emit(Resource.Loading<Repository>())
            val repoDetail = repository.listRepoDetails(owner, repo)
            emit(Resource.Success(repoDetail))
        } catch (e: HttpException) {
            emit(
                Resource.Error<Repository>(
                    e.localizedMessage ?: "An unexpected error occurred"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error<Repository>("Couldn't reach server. Check your internet connection"))
        }

    }
}

