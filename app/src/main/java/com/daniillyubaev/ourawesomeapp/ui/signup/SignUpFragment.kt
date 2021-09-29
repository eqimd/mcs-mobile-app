package com.daniillyubaev.ourawesomeapp.ui.signup

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.daniillyubaev.ourawesomeapp.ui.base.BaseFragment
import com.daniillyubaev.ourawesomeapp.R
import com.daniillyubaev.ourawesomeapp.databinding.FragmentSignUpBinding

class SignUpFragment : BaseFragment(R.layout.fragment_sign_up) {
    private val viewModel: SignUpViewModel by viewModels()
    private val viewBinding by viewBinding(FragmentSignUpBinding::bind)
}
