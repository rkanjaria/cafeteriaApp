package com.example.cafeteria.ui.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cafeteria.Event
import com.example.cafeteria.data.CafeteriaRepository

class LoginViewModel(context: Application, repository: CafeteriaRepository) : AndroidViewModel(context) {

    private val _navigateToHome = MutableLiveData<Event<Unit>>()
    val navigateToHome: LiveData<Event<Unit>>
        get() = _navigateToHome

    fun navigateToHome() {
        _navigateToHome.value = Event(Unit)
    }
}