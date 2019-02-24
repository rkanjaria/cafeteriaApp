package com.example.cafeteria

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cafeteria.data.CafeteriaRepository
import com.example.cafeteria.ui.login.LoginViewModel

class ViewModelFactory private constructor(
    private val application: Application,
    private val repository: CafeteriaRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>) =
        with(modelClass) {
            when {

                // write all the viewModels here

                isAssignableFrom(LoginViewModel::class.java) ->
                    LoginViewModel(application, repository)

                else -> throw IllegalArgumentException("Unknown viewModel class ${modelClass.name}")
            }
        } as T

    companion object {
        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        fun getInstance(application: Application) =
            INSTANCE ?: synchronized(ViewModelFactory::class.java) {
                INSTANCE ?: ViewModelFactory(
                    application,
                    Injection.provideCafeteriaRepository(application)
                ).also { INSTANCE = it }
            }
    }
}