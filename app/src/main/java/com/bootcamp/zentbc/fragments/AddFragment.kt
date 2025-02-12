package com.bootcamp.zentbc.fragments

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bootcamp.zentbc.MainActivity
import com.bootcamp.zentbc.R
import com.bootcamp.zentbc.databinding.FragmentAddBinding
import com.bootcamp.zentbc.databinding.FragmentHomeBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddFragment : Fragment() {
    private lateinit var binding: FragmentAddBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var databaseManager: DatabaseManager
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(layoutInflater)
        sharedPreferences = context?.getSharedPreferences(
            getString(R.string.prefs_key), MODE_PRIVATE
        )!!
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).bottomMenuVisibility(false)
        databaseManager = DatabaseManager.getINSTANCE(requireContext())

        binding.btnBack.setOnClickListener { _ ->
            findNavController().popBackStack()
        }

        binding.btnCreate.setOnClickListener { _ ->
            lifecycleScope.launch(Dispatchers.IO) {
                val title = binding.editTxtTitle.text.toString()
                val description = binding.editTxtDescription.text.toString()
                if (title.isEmpty() || description.isEmpty()) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            requireContext(), "Doldur butun xanalari",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    return@launch
                }

                val author = sharedPreferences.getString(getString(R.string.fullname2),"HHHHH")
                val todoModel = TodoModel(title = title, description = description, author =author!!)
                databaseManager.todoDao().insert(todoModel)
                val allList =   databaseManager.todoDao().getAllTodo()
                allList
                withContext(Dispatchers.Main){
                Toast.makeText(requireContext(),"SUCCESS", Toast.LENGTH_SHORT).show()
                    binding.title.setText("")
                    binding.editTxtDescription.setText("")
                    }
            }
        }
    }
}