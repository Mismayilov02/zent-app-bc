package com.bootcamp.zentbc.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.bootcamp.zentbc.R
import com.bootcamp.zentbc.databinding.FragmentAddBinding
import com.bootcamp.zentbc.databinding.FragmentHomeBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddFragment : Fragment() {
    private lateinit var binding: FragmentAddBinding
    private lateinit var databaseManager: DatabaseManager
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        databaseManager = DatabaseManager.getINSTANCE(requireContext())

        binding.btnCreate.setOnClickListener { _ ->
            lifecycleScope.launch(Dispatchers.IO) {
                val title = binding.editTxtTitle.text.toString()
                val description = binding.editTxtDescription.text.toString()
                val todoModel = TodoModel(title = title, description = description)
                databaseManager.todoDao().insert(todoModel)
                val allList =   databaseManager.todoDao().getAllTodo()
                allList
                withContext(Dispatchers.Main){
                Toast.makeText(requireContext(),"SUCCESS", Toast.LENGTH_SHORT).show()
                    }
            }
        }
    }
}