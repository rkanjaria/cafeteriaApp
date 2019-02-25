package com.example.cafeteria.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.cafeteria.R
import com.example.cafeteria.databinding.ActivityLoginBinding
import com.example.cafeteria.obtainViewModel
import com.example.cafeteria.ui.home.HomeActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mViewModel = obtainViewModel().apply {
            navigateToHome.observe(this@LoginActivity, Observer { unit ->
                unit.getContentIfNotHandled()?.let {
                    val homeIntent = Intent(this@LoginActivity, HomeActivity::class.java)
                    startActivity(homeIntent)
                }
            })
        }

        DataBindingUtil.setContentView<ActivityLoginBinding>(this@LoginActivity, R.layout.activity_login).apply {
            viewModel = mViewModel
            lifecycleOwner = this@LoginActivity
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun obtainViewModel(): LoginViewModel = obtainViewModel(LoginViewModel::class.java)
}
