package com.example.cafeteria.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cafeteria.R
import com.example.cafeteria.setUpToolbar

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setUpToolbar(R.id.toolbar) {
            setDisplayHomeAsUpEnabled(true)
            title = "Home"
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
