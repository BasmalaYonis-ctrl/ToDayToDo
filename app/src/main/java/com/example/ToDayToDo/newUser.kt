package com.example.ToDayToDo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.ToDayToDo.databinding.FragmentNewUserBinding


class newUser : Fragment() {
    lateinit var binding: FragmentNewUserBinding
    val viewModel: SharedViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewUserBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addUser.setOnClickListener {
            val name = binding.name.text.toString()
            val email = binding.email.text.toString()
            val phone = binding.phone.text.toString()

            // Create a new User object
            val newUser = user(id,name, email, phone)

            // Add the new user to the shared ViewModel
            viewModel.addUser(newUser)
            findNavController().popBackStack()
            // Optionally navigate back to the list fragment or clear input fields
            // findNavController().navigateUp() // Example of navigation
        }

    }
}