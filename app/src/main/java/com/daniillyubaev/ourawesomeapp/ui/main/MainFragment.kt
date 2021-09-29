package com.daniillyubaev.ourawesomeapp.ui.main

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.daniillyubaev.ourawesomeapp.ui.base.BaseFragment
import com.daniillyubaev.ourawesomeapp.R
import com.daniillyubaev.ourawesomeapp.databinding.FragmentMainBinding
import com.daniillyubaev.ourawesomeapp.ui.MainViewModel

class MainFragment : BaseFragment(R.layout.fragment_main) {
    private val viewModel: MainViewModel by viewModels()
    private val viewBinding by viewBinding(FragmentMainBinding::bind)
}
