package com.daniillyubaev.ourawesomeapp.ui.news

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.daniillyubaev.ourawesomeapp.R
import com.daniillyubaev.ourawesomeapp.databinding.FragmentNewsBinding
import com.daniillyubaev.ourawesomeapp.ui.base.BaseFragment

class NewsFragment : BaseFragment(R.layout.fragment_news) {
    private val viewModel: NewsViewModel by viewModels()
    private val viewBinding by viewBinding(FragmentNewsBinding::bind)
}