package com.dean.tombasinproject.activity

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.dean.tombasinproject.R
import com.dean.tombasinproject.ui.dashboard.DashboardFragment
import com.dean.tombasinproject.ui.home.HomeFragment
import com.dean.tombasinproject.ui.notifications.NotificationsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId){
                R.id.navigation_home -> {
                    val homeFragment = HomeFragment()
                    addFragment(homeFragment)
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigation_dashboard -> {
                    val dashboardFragment = DashboardFragment()
                    addFragment(dashboardFragment)
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigation_notifications -> {
                    val notificationFragment = NotificationsFragment()
                    addFragment(notificationFragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }


    private fun addFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fm_main_container, fragment, fragment::class.java.simpleName)
            .addToBackStack(null).commit()
    }
    val defaultMainView = HomeFragment.defaultFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        nav_main.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        addFragment(defaultMainView)
    }

}