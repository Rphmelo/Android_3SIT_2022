package br.com.fiap.checkpointcorrecao

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.fiap.checkpointcorrecao.database.StudentDatabase
import br.com.fiap.checkpointcorrecao.databinding.FragmentStudentListBinding

class StudentListFragment : Fragment() {

    private var binding: FragmentStudentListBinding? = null
    private val studentAdapter by lazy {
        StudentAdapter()
    }
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
        binding = FragmentStudentListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews(){
        binding?.recyclerViewStudents?.apply {
            setHasFixedSize(true)
            adapter = studentAdapter
        }
        binding?.buttonAddStudent?.setOnClickListener { view ->
            findNavController().navigate(R.id.action_to_register_student)
        }

        getDataFromDatabase()
    }

    private fun getDataFromDatabase() {
        appDb?.studentDao()?.getAll()?.let {
            studentAdapter.setData(it)
        }
    }
}