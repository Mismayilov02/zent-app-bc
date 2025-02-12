package com.bootcamp.zentbc.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.bootcamp.zentbc.MainActivity
import com.bootcamp.zentbc.R
import com.bootcamp.zentbc.databinding.FragmentHomeBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class HomeFragment : Fragment() {
    private lateinit var databaseManager: DatabaseManager
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        databaseManager = DatabaseManager.getINSTANCE(requireContext())
        (activity as MainActivity).bottomMenuVisibility(true)

        lifecycleScope.launch(Dispatchers.IO){
            val todoList   = databaseManager.todoDao().getAllTodo()
            val adapter = ListAdapter(requireContext(),todoList.toMutableList())

            adapter.deleteClick = {todoModel->
                lifecycleScope.launch(Dispatchers.IO) {

                    databaseManager.todoDao().delete(todo = todoModel)


                    val todoList  = databaseManager.todoDao().getAllTodo()


                    withContext(Dispatchers.Main){
                        Toast.makeText(requireContext(),"deyirler ki ugrla silindi" , Toast.LENGTH_SHORT).show()
                        adapter.updateData(todoList.toMutableList())

                    }
                }

            }

            withContext(Dispatchers.Main){
            binding.listView.adapter = adapter
                }
        }


    }
}