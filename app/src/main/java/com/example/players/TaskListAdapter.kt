package com.example.players

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskListAdapter(private val listTask: List<Task>,
                      private val openTaskDetail:(task: Task) -> Unit): RecyclerView.Adapter<TaskListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskListViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_task, parent, false)

        return TaskListViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskListViewHolder, position: Int) {
        val item = listTask[position]
        holder.bind(item, openTaskDetail)
    }

    override fun getItemCount(): Int {
        return listTask.size
    }
}

class TaskListViewHolder(private val view: View) : RecyclerView.ViewHolder(view){

    val tvTitle = view.findViewById<TextView>(R.id.tv_task_title)
    val tvDescr = view.findViewById<TextView>(R.id.tv_task_description)
    val tvImage = view.findViewById<ImageView>(R.id.image_view)
    val tvAge = view.findViewById<TextView>(R.id.tv_task_age)
    val tvNumber = view.findViewById<TextView>(R.id.tv_task_number)

    fun bind(task: Task,
             openTaskDetail:(task: Task) -> Unit){
        tvTitle.text = task.title
        tvDescr.text = task.description
        tvAge.text = task.age
        tvNumber.text = task.number
        tvImage.setImageResource(task.image)

        view.setOnClickListener {
            openTaskDetail.invoke(task)
        }
    }
}