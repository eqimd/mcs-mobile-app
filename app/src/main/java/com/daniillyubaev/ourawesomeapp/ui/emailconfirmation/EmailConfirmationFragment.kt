package com.daniillyubaev.ourawesomeapp.ui.emailconfirmation

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.daniillyubaev.ourawesomeapp.ui.base.BaseFragment
import com.daniillyubaev.ourawesomeapp.R
import com.daniillyubaev.ourawesomeapp.databinding.FragmentEmailConfirmationBinding

class EmailConfirmationFragment : BaseFragment(R.layout.fragment_email_confirmation) {
    private val viewModel: EmailConfirmationViewModel by viewModels()
    private val viewBinding by viewBinding(FragmentEmailConfirmationBinding::bind)
}
