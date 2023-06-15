package com.example.painthings.ui.auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.painthings.view_model.LoginViewModel
import com.example.painthings.R
import com.example.painthings.databinding.FragmentLoginBinding
import com.example.painthings.network.LoginBody
import com.example.painthings.ui.HomeActivity
import io.github.muddz.styleabletoast.StyleableToast

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[LoginViewModel::class.java]

        viewModel.getLoginStatus().observe(viewLifecycleOwner) {
            showLoading(false)
            Log.d("LOGIN", it.name.toString())
            if (it.email == binding.edEmail.text.toString()) {
                val sharedPreferences = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
                with(sharedPreferences.edit()) {
                    putString("cookies", it.finalsession)
                    putString("name", it.name)
                    apply()
                }
                StyleableToast.makeText(requireContext(), "Welcome home, ${it.name}", Toast.LENGTH_LONG, R.style.mytoast).show()
                val i = Intent(requireContext(), HomeActivity::class.java)
                startActivity(i)
            } else {
                StyleableToast.makeText(requireContext(), "Login unsuccessful", Toast.LENGTH_LONG, R.style.mytoast).show()
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListeners()
    }

    private fun setListeners() {
        binding.apply {
            btnLogin.setOnClickListener {
                loginUser()
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

    private fun showLoading(state: Boolean) {
        if (state) {
            binding.loginProgressBar.visibility = View.VISIBLE
        } else {
            binding.loginProgressBar.visibility = View.GONE
        }
    }

    private fun loginUser() {
        binding.apply {
            val req = LoginBody(
                edEmail.text.toString(),
                edPassword.text.toString()
            )
            showLoading(true)
            viewModel.login(req)
        }
    }
}