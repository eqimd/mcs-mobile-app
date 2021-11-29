package com.daniillyubaev.ourawesomeapp.ui.emailconfirmation


import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.daniillyubaev.ourawesomeapp.ui.base.BaseFragment
import com.daniillyubaev.ourawesomeapp.R
import com.daniillyubaev.ourawesomeapp.databinding.FragmentEmailConfirmationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EmailConfirmationFragment : BaseFragment(R.layout.fragment_email_confirmation) {

    private val viewBinding by viewBinding(FragmentEmailConfirmationBinding::bind)

    private val viewModel: EmailConfirmationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.firstname = savedInstanceState?.getString("SIGN_UP_FIRSTNAME") ?: ""
        viewModel.lastname = savedInstanceState?.getString("SIGN_UP_LASTNAME") ?: ""
        viewModel.nickname = savedInstanceState?.getString("SIGN_UP_NICKNAME") ?: ""
        viewModel.email = savedInstanceState?.getString("SIGN_UP_EMAIL") ?: ""
        viewModel.password = savedInstanceState?.getString("SIGN_UP_PASSWORD") ?: ""
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
        viewBinding.confirmVerificationCodeButton.setOnClickListener {
            viewModel.confirmVerificationCode(
                code = viewBinding.verificationCodeEditText.getCode()
            )
        }
        viewBinding.verificationCodeEditText.onVerificationCodeFilledChangeListener = {
            viewBinding.confirmVerificationCodeButton.isEnabled = it
        }
    }
}