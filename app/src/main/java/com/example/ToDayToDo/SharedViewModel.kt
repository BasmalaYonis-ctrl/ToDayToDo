package com.example.ToDayToDo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel:ViewModel() {
    // Private mutable list of users
    private val _userList = MutableLiveData<List<user>>()

    // Public LiveData for observing changes in the user list
    val userList: LiveData<List<user>> get() = _userList

    // Initialize the list with an empty list or some default values
    init {
        _userList.value = listOf()
    }

    // Function to add a new user to the list
    fun addUser(user: user) {
        val updatedList = _userList.value?.toMutableList() ?: mutableListOf()
        updatedList.add(user)
        _userList.value = updatedList
    }

    fun removeUser(userToRemove: user) {
        val currentList = _userList.value?.toMutableList() ?: mutableListOf()
        currentList.remove(userToRemove)
        _userList.value = currentList
    }

    fun updateUser(updatedUser: user) {
        val currentList = _userList.value?.toMutableList() ?: mutableListOf()
        val index = currentList.indexOfFirst { it.id == updatedUser.id }
        if (index != -1) {
            currentList[index] = updatedUser
            _userList.value = currentList
        }


    }
}