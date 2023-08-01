package com.example.players

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        setSupportActionBar(findViewById(R.id.toolbar))

        val taskList = listOf(
            Task(R.drawable.calleri,"Calleri", "Atacante do São Paulo Futebol Clube", "Idade: 29", "N° 9"),
            Task(R.drawable.luciano, "Luciano", "Atacante do São Paulo Futebol Clube", "Idade: 30", "N° 10"),
            Task(R.drawable.pato,"Pato", "Atacante do São Paulo Futebol Clube", "Idade: 33", "N° 12"),
            Task(R.drawable.rafael, "Rafael", "Goleiro do São Paulo Futebol Clube", "Idade: 30", "N° 23"),
            Task(R.drawable.gabi_neves, "Gabi Neves", "Volante do São Paulo Futebol Clube", "Idade: 25", "N° 20"),
            Task(R.drawable.galoppo, "Galoppo", "Meio Campista do São Paulo Futebol Clube", "Idade: 24", "N° 14"),
            Task(R.drawable.pablo_maia, "Pablo Maia", "Volante do São Paulo Futebol Clube", "Idade: 21", "N° 29"),
            Task(R.drawable.arboleda, "Arboleda", "Zagueiro do São Paulo Futebol Clube", "Idade: 31","N° 5"),
            Task(R.drawable.beraldo, "Beraldo", "Zagueiro do São Paulo Futebol Clube", "Idade: 19", "N° 35"),
            Task(R.drawable.diego_costa, "Diego Costa", "Zagueiro do São Paulo Futebol Clube", "Idade: 23", "N° 4"),
            Task(R.drawable.rato, "Wellington Rato", "Meio Campista do São Paulo Futebol Clube", "Idade: 31", "N° 27"),
            Task(R.drawable.luan, "Luan", "Volante do São Paulo Futebol Clube", "Idade: 24", "N° 8"),
            Task(R.drawable.michel_araujo, "Michel Araújo", "Meio Campista do São Paulo Futebol Clube", "Idade: 26", "N° 15"),
            Task(R.drawable.nestor, "Rodrigo Nestor", "Meio Campista do São Paulo Futebol Clube", "Idade: 22", "N° 11"),
            Task(R.drawable.rafinha, "Rafinha", "Lateral Direito do São Paulo Futebol Clube", "Idade: 37", "N° 13"),
            Task(R.drawable.caio_paulista, "Caio Paulista", "Lateral Esquerdo do São Paulo Futebol Clube", "Idade: 25", "N° 38"),
            Task(R.drawable.igor_vinicius, "Igor Vinícius", "Lateral Direito do São Paulo Futebol Clube", "Idade: 26", "N° 2"),
            Task(R.drawable.dvd, "David", "Atacante do São Paulo Futebol Clube", "Idade: 27", "N° 22"),
            Task(R.drawable.marcos_paulo, "Marcos Paulo", "Atacante do São Paulo Futebol Clube", "Idade: 22", "N° 32"),
            Task(R.drawable.alan_franco, "Alan Franco", "Zagueiro do São Paulo Futebol Clube", "Idade: 26","N° 28"),
        )

        val adapter = TaskListAdapter(taskList, ::openTaskDetail)
        val rvTask = findViewById<RecyclerView>(R.id.rv_task_list)
        rvTask.adapter = adapter
    }

    private fun openTaskDetail (task: Task){
        val intent = Intent(this, TaskDetailActivity::class.java)
            .apply {
                putExtra(TaskDetailActivity.TASK_TITLE_EXTRA, task.title)
                putExtra(TaskDetailActivity.TASK_IMAGE_EXTRA, task.image)
            }
        startActivity(intent)
    }
}