package com.daniillyubaev.ourawesomeapp.ui.profile

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.daniillyubaev.ourawesomeapp.R
import com.daniillyubaev.ourawesomeapp.databinding.FragmentProfileBinding
import com.daniillyubaev.ourawesomeapp.ui.base.BaseFragment

class ProfileFragment : BaseFragment(R.layout.fragment_profile) {
    private val viewModel: ProfileViewModel by viewModels()
    private val viewBinding by viewBinding(FragmentProfileBinding::bind)
}