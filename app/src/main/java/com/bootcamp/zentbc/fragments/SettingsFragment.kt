package com.bootcamp.zentbc.fragments

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bootcamp.zentbc.R
import com.bootcamp.zentbc.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {
    private lateinit var binding: FragmentSettingsBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(layoutInflater)
        sharedPreferences = context?.getSharedPreferences(
            getString(R.string.prefs_key), MODE_PRIVATE
        )!!
        editor = sharedPreferences.edit()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogout.setOnClickListener { _ ->
            editor.putBoolean("isLoggedin", false)
            editor.apply()
            findNavController().navigate(R.id.action_settingsFragment_to_splahScreenFragment)
        }
    }
}