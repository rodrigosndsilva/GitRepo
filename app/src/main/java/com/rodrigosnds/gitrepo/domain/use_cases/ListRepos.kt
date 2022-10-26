package com.rodrigosnds.gitrepo.domain.use_cases

import com.rodrigosnds.gitrepo.data.repository.GitRepoRepository
import javax.inject.Inject

class ListRepos @Inject constructor(private val repository: GitRepoRepository) {

    suspend operator fun invoke(
        name: String,
        sort: String,
        order: String,
    ) = repository.listRepos(name, sort, order)
}