package com.example.islami.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.islami.R
import com.example.islami.databinding.ActivityHomeBinding
import com.example.islami.hadethFragment.HadethFragment
import com.example.islami.quranFragment.QuranFragment
import com.example.islami.radioFragment.RadioFragment
import com.example.islami.sebhaFragment.SebhaFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    lateinit var bottomNavigation : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
       bottomNavigation = binding.content.BottomNavigation
        showFragment(QuranFragment())
        bottomNavigation.setOnItemSelectedListener { item->
            FragmentNavigaation(item)
            return@setOnItemSelectedListener true
        }

    }

    private fun FragmentNavigaation(item: MenuItem) {
        if (item.itemId == R.id.navigation_radio) {
            showFragment(RadioFragment())
        } else if (item.itemId == R.id.navigation_quran) {
            showFragment(QuranFragment())
        } else if (item.itemId == R.id.navigation_sebha) {
            showFragment(SebhaFragment())
        } else if (item.itemId == R.id.navigation_ahadeth) {
            showFragment(HadethFragment())
        }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction( )
            .replace(R.id.Fragment_Container,fragment)
            .commit()

    }

}