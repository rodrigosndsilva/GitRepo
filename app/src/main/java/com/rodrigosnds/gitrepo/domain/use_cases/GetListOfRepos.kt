package com.rodrigosnds.gitrepo.domain.use_cases

import android.util.Log
import com.rodrigosnds.gitrepo.common.Resource
import com.rodrigosnds.gitrepo.data.repository.GitRepoRepository
import com.rodrigosnds.gitrepo.domain.model.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class GetListOfRepos @Inject constructor(
    private val repository: GitRepoRepository
) {
    operator fun invoke(
        name: String,
        sort: String,
        order: String
    ): Flow<Resource<List<Repository>>> = flow {
        try {
            emit(Resource.Loading<List<Repository>>())
            val repoList = repository.getListOfRepos(name, sort, order)
            emit(Resource.Success<List<Repository>>(repoList))
        } catch (e: HttpException) {
            emit(
                Resource.Error<List<Repository>>(
                    e.localizedMessage ?: "An unexpected error occurred"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error<List<Repository>>("Couldn't reach server. Check your internet connection"))
        }

    }
}
