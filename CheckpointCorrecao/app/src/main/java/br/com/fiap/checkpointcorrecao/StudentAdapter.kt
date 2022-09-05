package br.com.fiap.checkpointcorrecao

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.checkpointcorrecao.database.StudentInfo
import br.com.fiap.checkpointcorrecao.databinding.StudentItemBinding

class StudentAdapter : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    private var studentList: MutableList<StudentInfo> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val binding = StudentItemBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.student_item, parent, false))
        return StudentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bindView(studentList[position])
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    fun setData(list: List<StudentInfo>) {
        with(studentList) {
            clear()
            addAll(list)
        }
        notifyDataSetChanged()
    }

    inner class StudentViewHolder(
        private val view: StudentItemBinding
    ) : RecyclerView.ViewHolder(view.root) {

        fun bindView(countryInfo: StudentInfo) {
            view.studentNameValue.text = countryInfo.name
            view.studentRmValue.text = countryInfo.rm
            view.studentGradeValue.text = countryInfo.grade
        }
    }
}