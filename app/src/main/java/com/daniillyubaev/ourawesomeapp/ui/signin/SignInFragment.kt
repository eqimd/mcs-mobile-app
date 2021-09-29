package com.daniillyubaev.ourawesomeapp.ui.signin

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.daniillyubaev.ourawesomeapp.ui.base.BaseFragment
import com.daniillyubaev.ourawesomeapp.R
import com.daniillyubaev.ourawesomeapp.databinding.FragmentSignInBinding

class SignInFragment : BaseFragment(R.layout.fragment_sign_in) {
        private val viewModel: SignInViewModel by viewModels()
        private val viewBinding by viewBinding(FragmentSignInBinding::bind)
}