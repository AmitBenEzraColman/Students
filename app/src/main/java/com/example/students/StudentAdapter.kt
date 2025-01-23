package com.example.students

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(
    private val studentList: List<Student>,
    private val onStudentClick: (Student) -> Unit
) : RecyclerView.Adapter<StudentAdapter.StudentListViewHolder>() {

    inner class StudentListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textStudentId: TextView = itemView.findViewById(R.id.studentId)
        val checkboxStudent: CheckBox = itemView.findViewById(R.id.studentCheckbox)
        val studentImg: ImageView = itemView.findViewById(R.id.studentImg)
        val textStudentName: TextView = itemView.findViewById(R.id.studentName)
    }

    override fun onBindViewHolder(holder: StudentListViewHolder, position: Int) {
        val currentStudent = studentList[position]
        holder.studentImg.setImageResource(currentStudent.image)
        holder.textStudentName.text = currentStudent.name
        holder.textStudentId.text = currentStudent.id
        holder.checkboxStudent.isChecked = currentStudent.isChecked

        holder.checkboxStudent.setOnCheckedChangeListener { _, isChecked ->
            currentStudent.isChecked = isChecked
        }

        holder.itemView.setOnClickListener { onStudentClick(currentStudent) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.student_item, parent, false)
        return StudentListViewHolder(view)
    }

    override fun getItemCount() = studentList.size
}
