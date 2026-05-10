package com.example.a206684_biexianhe_izwan_lab1_1.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {


    var userName by mutableStateOf("")
    var studentId by mutableStateOf("")
    var isLoggedIn by mutableStateOf(false)


    fun login(name: String, id: String) {
        userName = name
        studentId = id
        isLoggedIn = true
    }


    fun logout() {
        userName = ""
        studentId = ""
        isLoggedIn = false
    }
}