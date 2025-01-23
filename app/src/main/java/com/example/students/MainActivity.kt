package com.example.students

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    companion object {
        val students = mutableListOf(
            Student("1", "Yarin", false, R.drawable.ic_student_placeholder, "123-456-7890", "123 Main St"),
            Student("2", "Amit", true, R.drawable.ic_student_placeholder, "987-654-3210", "456 Main St"),
            Student("3", "Bobi", false, R.drawable.ic_student_placeholder, "555-555-5555", "789 Mai St")
        )
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: StudentAdapter

    @SuppressLint("NotifyDataSetChanged")
    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}


