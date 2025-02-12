package com.bootcamp.zentbc.fragments

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.annotation.UiContext
import com.bootcamp.zentbc.databinding.ListDesignBinding
import java.text.SimpleDateFormat

class ListAdapter constructor(context: Context,private var todoList: MutableList<TodoModel>): ArrayAdapter<TodoModel>(context,0,todoList){

    var deleteClick:((TodoModel)-> Unit)? = null
    val simpleDateTimeForamt = SimpleDateFormat("HH:mm dd/MMM/YYYY")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ListDesignBinding.inflate(LayoutInflater.from(context),parent,false)
        val item = todoList[position]
        binding.listTitle.text = item.title
        binding.listDescription.text = item.description
        binding.listStatus.text = item.status.name
        binding.deadline.text = simpleDateTimeForamt.format(item.deadline)
        binding.txtAuthor.text = item.author

        binding.statusCard.setOnClickListener { _ ->
            val status = if (binding.listStatus.text.equals(TodoStatus.DONE)) TodoStatus.TODO else TodoStatus.DONE
            todoList[position].status = status
            notifyDataSetChanged()
        }

        binding.designCard.setOnLongClickListener { p0 ->
            deleteClick?.invoke(item)
            true
        }

        return binding.root
    }

    fun updateData(todoList: MutableList<TodoModel>){
        this.todoList.clear()
        this.todoList.addAll(todoList)
        notifyDataSetChanged()
    }
}