package com.example.players

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class TaskDetailActivity : AppCompatActivity() {

    companion object{
        val TASK_TITLE_EXTRA = "task.title.extra.detail"
        val TASK_IMAGE_EXTRA = "task.image.extra.detail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_detail)

        val tvTitle = findViewById<TextView>(R.id.tv_task_list_detail)
        val title = intent.getStringExtra(TASK_TITLE_EXTRA) ?:""

        tvTitle.text = title

        val imageDetail = findViewById<ImageView>(R.id.image_task_list_detail)
        val imagem = intent.getIntExtra(TASK_IMAGE_EXTRA, 0)

        imageDetail.setImageResource(imagem)

        val btnBack = findViewById<ImageButton>(R.id.btn_back)

        btnBack.setOnClickListener {
            finish()
        }
    }
}