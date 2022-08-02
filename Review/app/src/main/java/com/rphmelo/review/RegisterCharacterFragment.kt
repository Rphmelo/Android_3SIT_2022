package com.rphmelo.review

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.rphmelo.review.databinding.FragmentRegisterCharacterBinding

class RegisterCharacterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterCharacterBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register_character, container, false)
        return binding.root
    }
}