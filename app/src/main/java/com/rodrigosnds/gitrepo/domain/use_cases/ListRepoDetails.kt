package com.rodrigosnds.gitrepo.domain.use_cases

import com.rodrigosnds.gitrepo.data.repository.GitRepoRepository
import javax.inject.Inject

class ListRepoDetails @Inject constructor(private val repository: GitRepoRepository) {

    suspend operator fun invoke(
        owner: String, repo: String,
    ) = repository.listRepoDetails(owner, repo)
}

