package com.bootcamp.zentbc.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bootcamp.zentbc.R
import com.bootcamp.zentbc.databinding.FragmentOnboardingBinding


class OnboardingFragment : Fragment() {

    lateinit var binding: FragmentOnboardingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOnboardingBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnOnboarding.setOnClickListener { p0 ->
            findNavController().navigate(R.id.action_onboardingFragment_to_registerFragment)
        }
    }

}