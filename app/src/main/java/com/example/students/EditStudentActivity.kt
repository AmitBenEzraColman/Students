package com.example.students

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.students.R
import com.example.students.MainActivity

public class EditStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_student)

        supportActionBar?.apply {
            title = "Student Details"
        }

        val selectedStudentId = intent.getStringExtra("studentId")
        val selectedStudent = MainActivity.students.find { it.id == selectedStudentId } ?: return

        val inputName = findViewById<EditText>(R.id.nameInput)
        val inputId = findViewById<EditText>(R.id.idInput)
        val inputPhone = findViewById<EditText>(R.id.phoneInput)
        val inputAddress = findViewById<EditText>(R.id.addressInput)
        val buttonSave = findViewById<Button>(R.id.saveButton)
        val buttonDelete = findViewById<Button>(R.id.deleteButton)
        val buttonCancel = findViewById<Button>(R.id.cancelButton)

        inputName.setText(selectedStudent.name)
        inputId.setText(selectedStudent.id)
        inputPhone.setText(selectedStudent.phoneNumber)
        inputAddress.setText(selectedStudent.address)

        buttonSave.setOnClickListener {
            selectedStudent.name = inputName.text.toString()
            selectedStudent.id = inputId.text.toString()
            selectedStudent.phoneNumber = inputPhone.text.toString()
            selectedStudent.address = inputAddress.text.toString()

            navigateToMainActivity()
        }

        buttonDelete.setOnClickListener {
            MainActivity.students.remove(selectedStudent)
            navigateToMainActivity()
        }

        buttonCancel.setOnClickListener {
            navigateToMainActivity()
        }
    }

    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
