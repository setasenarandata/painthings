package com.example.painthings.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.painthings.R
import com.example.painthings.databinding.FragmentLoginBinding
import com.example.painthings.ui.HomeActivity

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListeners()
    }

    private fun setListeners() {
        binding.apply {
            btnLogin.setOnClickListener {
                val iMain = Intent(requireContext(), HomeActivity::class.java)
                startActivity(iMain)
            }

            btnToRegister.setOnClickListener {
                parentFragmentManager.beginTransaction().apply {
                    replace(
                        R.id.auth_container,
                        RegisterFragment(),
                        RegisterFragment::class.java.simpleName
                    )
                        .commit()
                }
            }
        }
    }
}