package com.rodrigosnds.gitrepo.domain.use_cases

import com.rodrigosnds.gitrepo.data.repository.GitRepoRepository
import javax.inject.Inject


class ListUserRepos @Inject constructor(
    private val repository: GitRepoRepository
) {
    suspend operator fun invoke(
        user: String
    ) = repository.listUserRepos(user)
}
