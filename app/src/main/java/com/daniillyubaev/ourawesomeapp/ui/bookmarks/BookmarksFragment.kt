package com.daniillyubaev.ourawesomeapp.ui.bookmarks

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.daniillyubaev.ourawesomeapp.R
import com.daniillyubaev.ourawesomeapp.databinding.FragmentBookmarksBinding
import com.daniillyubaev.ourawesomeapp.ui.base.BaseFragment

class BookmarksFragment : BaseFragment(R.layout.fragment_bookmarks) {
    private val viewModel: BookmarksViewModel by viewModels()
    private val viewBinding by viewBinding(FragmentBookmarksBinding::bind)
}