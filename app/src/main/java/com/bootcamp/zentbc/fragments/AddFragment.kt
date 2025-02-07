package com.bootcamp.zentbc.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bootcamp.zentbc.R
import com.bootcamp.zentbc.databinding.FragmentAddBinding
import com.bootcamp.zentbc.databinding.FragmentHomeBinding

class AddFragment : Fragment() {
    private lateinit var binding: FragmentAddBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(layoutInflater)
        return inflater.inflate(R.layout.fragment_add, container, false)
    }
}