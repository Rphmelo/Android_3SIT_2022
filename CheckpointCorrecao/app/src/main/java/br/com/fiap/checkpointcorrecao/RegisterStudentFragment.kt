package br.com.fiap.checkpointcorrecao

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.fiap.checkpointcorrecao.database.StudentDatabase
import br.com.fiap.checkpointcorrecao.database.StudentInfo
import br.com.fiap.checkpointcorrecao.databinding.FragmentRegisterStudentBinding

class RegisterStudentFragment : Fragment() {

    private var binding: FragmentRegisterStudentBinding? = null
    private val appDb by lazy {
        view?.context?.let {
            StudentDatabase.getDatabase(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterStudentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        binding?.buttonBackToStudentList?.setOnClickListener {
            findNavController().navigateUp()
        }

        binding?.registerStudentButton?.setOnClickListener {
            insertData()
        }
    }

    private fun insertData() {
        binding?.run {
            val studentInfo = StudentInfo(
                name = textInputEditTextStudentName.text.toString(),
                rm = textInputEditTextStudentRM.text.toString(),
                grade = textInputEditTextStudentGrade.text.toString(),

            )
            appDb?.studentDao()?.insert(studentInfo)
            clearForm()
        }
    }

    private fun clearForm() {
        binding?.run {
            textInputEditTextStudentName.text?.clear()
            textInputEditTextStudentRM.text?.clear()
            textInputEditTextStudentGrade.text?.clear()
        }
    }
}