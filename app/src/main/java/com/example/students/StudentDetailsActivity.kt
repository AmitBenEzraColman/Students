package com.example.students

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.students.R
import com.example.students.MainActivity

class StudentDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        supportActionBar?.apply {
            title = "Student Information"
            setDisplayHomeAsUpEnabled(true)
        }

        val studentId = intent.getStringExtra("studentId")
        val student = MainActivity.students.find { it.id == studentId } ?: return

        val studentImg = findViewById<ImageView>(R.id.studentImg)
        val studentName = findViewById<TextView>(R.id.studentName)
        val studentViewId = findViewById<TextView>(R.id.studentId)
        val studentPhone = findViewById<TextView>(R.id.studentPhone)
        val studentAddress = findViewById<TextView>(R.id.studentAddress)

        val checkedIcon = findViewById<ImageView>(R.id.checkedIcon)
        val checkedStatusText = findViewById<TextView>(R.id.checkedStatusText)
        val editButton = findViewById<Button>(R.id.editButton)

        studentImg.setImageResource(student.image)
        studentName.text = student.name
        studentViewId.text = student.id
        studentPhone.text = student.phoneNumber
        studentAddress.text = student.address

        if (student.isChecked) {
            checkedIcon.visibility = ImageView.VISIBLE
            checkedStatusText.visibility = TextView.VISIBLE
        }

        editButton.setOnClickListener {
            val intent = Intent(this, EditStudentActivity::class.java)
            intent.putExtra("studentId", student.id)
            startActivity(intent)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onResume() {
        super.onResume()
        val studentId = intent.getStringExtra("studentId")
        val student = MainActivity.students.find { it.id == studentId } ?: return

        findViewById<TextView>(R.id.studentName).text = "Name: ${student.name}"
        findViewById<TextView>(R.id.studentId).text = "ID: ${student.id}"
        findViewById<TextView>(R.id.studentPhone).text = "Phone: ${student.phoneNumber}"
        findViewById<TextView>(R.id.studentAddress).text = "Address: ${student.address}"

        val checkedIcon = findViewById<ImageView>(R.id.checkedIcon)
        val checkedStatusText = findViewById<TextView>(R.id.checkedStatusText)
        if (student.isChecked) {
            checkedIcon.visibility = ImageView.VISIBLE
            checkedStatusText.visibility = TextView.VISIBLE
        } else {
            checkedIcon.visibility = ImageView.GONE
            checkedStatusText.visibility = TextView.GONE
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}