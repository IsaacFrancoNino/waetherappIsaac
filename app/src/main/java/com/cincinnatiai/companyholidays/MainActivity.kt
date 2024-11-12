package com.cincinnatiai.companyholidays

import android.os.Binder
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cincinnatiai.companyholidays.databinding.ActivityMainBinding
import com.cincinnatiai.companyholidays.di.DIModule
import com.cincinnatiai.companyholidays.ui.holidays.HolidaysFragment
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .add(R.id.frame_layout,HolidaysFragment.newInstance())
                .commit()
        }
    }
}