package com.bootcamp.zentbc.fragments

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.bootcamp.zentbc.R
import com.bootcamp.zentbc.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    private lateinit var sharedPreferences: SharedPreferences

    private lateinit var editor: SharedPreferences.Editor

    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(layoutInflater)
        sharedPreferences = context?.getSharedPreferences(
            getString(R.string.prefs_key), MODE_PRIVATE
        )!!
        editor = sharedPreferences.edit()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegister.setOnClickListener { _ ->
            if (binding.editTxtFullName.text.isEmpty() || binding.editTxtEmail.text.isEmpty()
                || binding.editTxtPassword.text.isEmpty() || binding.editTxtCPassword.text.isEmpty()){
                showToast("Butun Xanalari doldur")
            }else if (!binding.editTxtEmail.text.contains("@") || !binding.editTxtEmail.text.contains(".")){
                showToast("Email dogru deyil")
            }else if (!binding.editTxtPassword.text.toString().equals(binding.editTxtCPassword.text.toString())){
                showToast("Sifreler uygun gelmir")
            }else {
                sharedPreferences
                editor
                    .putString(getString(R.string.fullname2), binding.editTxtFullName.text.toString())
                    .putString(getString(R.string.email2), binding.editTxtEmail.text.toString())
                    .putString(getString(R.string.password2), binding.editTxtPassword.text.toString())
                    .apply()

                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            }
        }

        binding.toLogin.setOnClickListener { _ ->
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }

    }

    private fun showToast(message: String){
        Toast.makeText(context,message , Toast.LENGTH_LONG).show()
    }

}