package com.bootcamp.zentbc.fragments

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bootcamp.zentbc.MainActivity
import com.bootcamp.zentbc.R

class SplashScreenFragment : Fragment() {
    private lateinit var sharedPreferences: SharedPreferences

    private lateinit var editor: SharedPreferences.Editor
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splah_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).bottomMenuVisibility(false)
        sharedPreferences = context?.getSharedPreferences(
            getString(R.string.prefs_key), MODE_PRIVATE
        )!!
        editor = sharedPreferences.edit()
        val isLoggedin = sharedPreferences.getBoolean("isLoggedin", false)
        view.postDelayed({
            findNavController().navigate( if (isLoggedin) R.id.action_splahScreenFragment_to_homeFragment
            else R.id.action_splahScreenFragment_to_onboardingFragment)
        }, 2500)
    }

}