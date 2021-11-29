package com.daniillyubaev.ourawesomeapp.ui.likes

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.daniillyubaev.ourawesomeapp.R
import com.daniillyubaev.ourawesomeapp.databinding.FragmentLikesBinding
import com.daniillyubaev.ourawesomeapp.ui.base.BaseFragment

class LikesFragment : BaseFragment(R.layout.fragment_likes){
        private val viewModel: LikesViewModel by viewModels()
        private val viewBinding by viewBinding(FragmentLikesBinding::bind)
}