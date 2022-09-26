package com.rodrigosnds.gitrepo.domain.use_cases

import com.rodrigosnds.gitrepo.common.Resource
import com.rodrigosnds.gitrepo.data.repository.GitRepoRepository
import com.rodrigosnds.gitrepo.domain.model.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class get_list_of_repos @Inject constructor(
    private val repository: GitRepoRepository
) {
    operator fun invoke(
        query: String,
        sort: String,
        order: String
    ): Flow<Resource<List<Repository>>> =
        flow {
            try {
                emit(Resource.Loading())
                val repoList = repository.getListOfRepos(query, sort, order)
                emit(Resource.Success(repoList))
            } catch (e: HttpException) {
                emit(
                    Resource.Error(
                        e.localizedMessage ?: "An unexpected error occurred"
                    )
                )
            } catch (e: IOException) {
                emit(Resource.Error("Couldn't reach server. Check your internet connection"))
            }

        }
}
