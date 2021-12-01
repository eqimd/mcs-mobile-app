package com.daniillyubaev.ourawesomeapp.ui.emailconfirmation

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
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
        viewBinding.confirmVerificationCodeButton.setOnClickListener {
            viewModel.confirmVerificationCode(
                code = viewBinding.verificationCodeEditText.getCode()
            )
        }
        viewBinding.confirmVerificationCodeButton.isEnabled = false
        viewBinding.verificationCodeEditText.onVerificationCodeFilledChangeListener = {
            viewBinding.confirmVerificationCodeButton.isEnabled = it
        }

//        AlertDialog.Builder(requireContext())
//            .setTitle(viewModel.firstname)
//            .setNegativeButton(R.string.sign_in_back_alert_dialog_cancel_button_text) { dialog, _ ->
//                dialog?.dismiss()
//            }
//            .setPositiveButton(R.string.sign_in_back_alert_dialog_ok_button_text) { _, _ ->
//                findNavController().popBackStack()
//            }
//            .show()
    }
}