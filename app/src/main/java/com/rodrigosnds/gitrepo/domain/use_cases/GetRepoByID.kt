package com.rodrigosnds.gitrepo.domain.use_cases

import com.rodrigosnds.gitrepo.common.Resource
import com.rodrigosnds.gitrepo.data.repository.GitRepoRepository
import com.rodrigosnds.gitrepo.domain.model.SpecificRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetRepoByID @Inject constructor(
    private val repository: GitRepoRepository
) {
    operator fun invoke(
        id: Int
    ): Flow<Resource<SpecificRepository>> = flow {
        try {
            emit(Resource.Loading<SpecificRepository>())
            val repoDetail = repository.getRepoByID(id)
            emit(Resource.Success<SpecificRepository>(repoDetail))
        } catch (e: HttpException) {
            emit(
                Resource.Error<SpecificRepository>(
                    e.localizedMessage ?: "An unexpected error occurred"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error<SpecificRepository>("Couldn't reach server. Check your internet connection"))
        }

    }
}

