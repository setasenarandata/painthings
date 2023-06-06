package com.example.painthings.ui.auth

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.fragment.app.Fragment
import com.example.painthings.R
import com.example.painthings.databinding.FragmentRegisterBinding
import java.text.SimpleDateFormat
import java.util.*

class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    private lateinit var calendar: Calendar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
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
                parentFragmentManager.beginTransaction().apply {
                    replace(
                        R.id.auth_container,
                        LoginFragment(),
                        LoginFragment::class.java.simpleName
                    )
                        .commit()
                }
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
        val myFormat = "dd/MM/yyyy"
        val dateFormat = SimpleDateFormat(myFormat, Locale.US)
        binding.edBirthDate.setText(dateFormat.format(calendar.time))
    }
}