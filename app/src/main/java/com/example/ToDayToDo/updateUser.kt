package com.example.ToDayToDo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.ToDayToDo.databinding.FragmentUpdateUserBinding


class updateUser : Fragment() {
    lateinit var binding: FragmentUpdateUserBinding
    private val viewModel: SharedViewModel by activityViewModels()
    private lateinit var user: user
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentUpdateUserBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Retrieve the user object passed as an argument
        arguments?.getSerializable("user")?.let {
            user = it as user
            populateFields(user)
        }

        binding.doneEdit.setOnClickListener {
            val updatedUser = user.copy(
                name = binding.name.text.toString(),
                email = binding.email.text.toString(),
                phone = binding.phone.text.toString()
            )
            viewModel.updateUser(updatedUser)
            findNavController().popBackStack() // Go back to the previous fragment
        }
    }
    private fun populateFields(user: user) {
        binding.name.setText(user.name)
        binding.email.setText(user.email)
        binding.phone.setText(user.phone)
    }

}