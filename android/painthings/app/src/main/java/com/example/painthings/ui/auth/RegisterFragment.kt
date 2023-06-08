package com.example.painthings.ui.auth

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.painthings.R
import com.example.painthings.databinding.FragmentRegisterBinding
import com.example.painthings.network.RegisterBody
import com.example.painthings.view_model.RegisterViewModel
import java.text.SimpleDateFormat
import java.util.*

class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    private lateinit var calendar: Calendar
    private lateinit var viewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[RegisterViewModel::class.java]

        viewModel.getStatus().observe(viewLifecycleOwner) {
            showLoading(false)
            if (it.msg == "Register Berhasil") {
                Toast.makeText(requireContext(), "Register successful", Toast.LENGTH_LONG).show()
                parentFragmentManager.beginTransaction().apply {
                    replace(
                        R.id.auth_container,
                        LoginFragment(),
                        LoginFragment::class.java.simpleName
                    )
                        .commit()
                }
            } else {
                Toast.makeText(requireContext(), "Register unsuccessful", Toast.LENGTH_LONG).show()
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setDateForm()
        setListeners()
    }

    private fun setDateForm() {
        calendar = Calendar.getInstance()

        val date =
            DatePickerDialog.OnDateSetListener { _: DatePicker?, year: Int, month: Int, day: Int ->
                calendar.set(Calendar.YEAR, year)
                calendar.set(Calendar.MONTH, month)
                calendar.set(Calendar.DAY_OF_MONTH, day)
                updateDateLabel()
            }

        binding.edBirthDate.setOnClickListener {
            DatePickerDialog(
                requireContext(),
                date,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }

    private fun setListeners() {
        binding.apply {
            btnRegister.setOnClickListener {
                registerUser()
            }

            btnToLogin.setOnClickListener {
                parentFragmentManager.beginTransaction().apply {
                    replace(
                        R.id.auth_container,
                        LoginFragment(),
                        LoginFragment::class.java.simpleName
                    )
                        .commit()
                }
            }
        }
    }

    private fun updateDateLabel() {
        val myFormat = "dd-MM-yyyy"
        val dateFormat = SimpleDateFormat(myFormat, Locale.US)
        binding.edBirthDate.setText(dateFormat.format(calendar.time))
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            binding.registerProgressBar.visibility = View.VISIBLE
        } else {
            binding.registerProgressBar.visibility = View.GONE
        }
    }

    private fun registerUser() {
        binding.apply {
            val req = RegisterBody(
                edName.text.toString(),
                edEmail.text.toString(),
                edPassword.text.toString(),
                edBirthDate.text.toString()
            )
            showLoading(true)
            viewModel.register(req)
        }
    }
}