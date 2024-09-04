package com.example.ToDayToDo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ToDayToDo.databinding.FragmentListBinding

class list : Fragment() {
    lateinit var binding: FragmentListBinding
    val userList:MutableList<user> = mutableListOf()
    val viewModel:SharedViewModel by activityViewModels()
    private lateinit var adapter: myAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentListBinding.inflate(layoutInflater)
      //  addUserToList()
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        adapter = myAdapter(userList)

//        binding.myList.apply {
//            layoutManager= GridLayoutManager(requireContext(),2)
//            adapter=myAdapter(userList)
//        }
//        binding.add.setOnClickListener{
//            findNavController().navigate(R.id.newUser)
//        }
//        viewModel.userList.observe(viewLifecycleOwner) { users ->
//            adapter.updateList(users)
//        }

        // Initialize the adapter with an empty list first
        adapter = myAdapter(
            listOf(),
            onDelete = { user ->
                viewModel.removeUser(user)
            },
            onUpdate = { user ->
                // Implement the update logic here, e.g., navigate to an update fragment
                findNavController().navigate(R.id.updateUser, Bundle().apply {
                    putSerializable("user", user) // Pass user object to update fragment
                })
            }
        )

        binding.myList.apply {
            layoutManager = GridLayoutManager(requireContext(), 1)
            adapter = this@list.adapter
        }

        binding.add.setOnClickListener {
            findNavController().navigate(R.id.newUser)
        }

        viewModel.userList.observe(viewLifecycleOwner) { users ->
            if (users.isEmpty()) {
                binding.myList.visibility = View.GONE
                binding.noUserText.visibility = View.VISIBLE
            } else {
                binding.myList.visibility = View.VISIBLE
                binding.noUserText.visibility = View.GONE
                adapter.updateList(users)
            }
        }
        binding.helpIcon.setOnClickListener{ findNavController().navigate(R.id.help)}
        binding.homeIcon.setOnClickListener{ findNavController().navigate(R.id.home2)}

    }
//    fun addUserToList(){
//        userList.add(user("basmala","basmala@gmail.com","03456788"))
//        userList.add(user("basmala","basmala@gmail.com","03456788"))
//
//    }


}