package com.rodrigosnds.gitrepo.ui.homescreen

import androidx.compose.ui.graphics.Color
import com.rodrigosnds.gitrepo.R
import com.rodrigosnds.gitrepo.domain.use_cases.ListRepos
import com.rodrigosnds.gitrepo.domain.use_cases.ListUserRepos
import io.mockk.mockk
import kotlinx.coroutines.flow.update
import org.junit.Assert
import org.junit.Test

internal class HomescreenViewModelTest {
    private var listRepos = mockk<ListRepos>()
    private var listUserRepos = mockk<ListUserRepos>()
    private var viewModel = HomescreenViewModel(listRepos, listUserRepos)

    @Test
    fun `Given a tab state USER, when getting the placeholder, then return id input_user_name_label`() {
        Assert.assertEquals(R.string.input_user_name_label, viewModel.getPlaceholder())
    }

    @Test
    fun `Given a tab state REPO, when getting the placeholder, then return id input_repo_name_label`() {
        viewModel.setState()
        Assert.assertEquals(R.string.input_repo_name_label, viewModel.getPlaceholder())
    }

    @Test
    fun switchedToUserTab() {
    }

    @Test
    fun switchedToRepoTab() {
    }

    @Test
    fun `Given a tab state USER, when getting user button color, then return color Blue`() {
        Assert.assertEquals(Color.Blue, viewModel.getBackgroundColorForUserBtn())
    }

    @Test
    fun `Given a tab state REPO, when getting user button color, then return color Gray`() {
        viewModel.setState()
        Assert.assertEquals(Color.Gray, viewModel.getBackgroundColorForUserBtn())
    }

    @Test
    fun `Given a tab state REPO, when getting repository button color, then return color Blue`() {
        viewModel.setState()
        Assert.assertEquals(Color.Blue, viewModel.getBackgroundColorForRepoBtn())
    }

    @Test
    fun `Given a tab state USER, when getting repository button color, then return color Gray`() {
        Assert.assertEquals(Color.Gray, viewModel.getBackgroundColorForRepoBtn())
    }

    @Test
    fun onResearch() {
        Assert.assertEquals(3, 2+2)
    }
}