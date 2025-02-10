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
import com.bootcamp.zentbc.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private lateinit var sharedPreferences: SharedPreferences

    private lateinit var editor: SharedPreferences.Editor

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        sharedPreferences = context?.getSharedPreferences(
            getString(R.string.prefs_key), MODE_PRIVATE
        )!!
        editor = sharedPreferences.edit()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnLogin.setOnClickListener { _ ->
            val email = sharedPreferences.getString(getString(R.string.email2), "No Email")
            val password = sharedPreferences.getString(getString(R.string.password2), "No Password")

            if (binding.editTxtEmail.text.toString().equals(email) &&
                binding.editTxtPassword.text.toString().equals(password)){
                editor.putBoolean("isLoggedin",true)
                editor.apply()
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            }
            else{
                Toast.makeText(context, "Email or password is incorrect.", Toast.LENGTH_LONG).show()
            }

        }

        binding.toRegister.setOnClickListener { _ ->
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

}