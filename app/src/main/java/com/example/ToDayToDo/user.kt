package com.example.ToDayToDo

import java.io.Serializable

data class user(
    val id: Int,
    val name:String,
    val email:String,
    val phone:String
):Serializable
