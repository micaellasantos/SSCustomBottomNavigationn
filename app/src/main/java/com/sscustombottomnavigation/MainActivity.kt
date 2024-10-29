package com.sscustombottomnavigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.simform.custombottomnavigation.Model
import com.sscustombottomnavigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {
        private const val ID_HOME = 0
        private const val ID_EXPLORE = 1
        private const val ID_MESSAGE = 2
        private const val ID_NOTIFICATION = 3
        private const val ID_ACCOUNT = 4
        private const val ID_MAP = 5 // Constant for Map Fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setBottomNavigationWithNavController(savedInstanceState)
    }

    private fun setBottomNavigationWithNavController(savedInstanceState: Bundle?) {
        val activeIndex = savedInstanceState?.getInt("activeIndex") ?: ID_HOME
        val navController = findNavController(R.id.nav_host_fragment)

        // Ensure only one instance of each fragment is in AppBarConfiguration
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_map,
                R.id.navigation_chat,
                R.id.navigation_courses,
                R.id.navigation_profile
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)

        // Updated menu items, including the map fragment
        val menuItems = arrayOf(
            Model(
                icon = R.drawable.ic_home,
                destinationId = R.id.navigation_home,
                id = ID_HOME,
                text = R.string.title_home,
                count = R.string.empty_value
            ),
            Model(
                R.drawable.ic_map,
                R.id.navigation_map, // Map Fragment destination
                ID_EXPLORE,
                R.string.title_map,
                R.string.empty_value
            ),
            Model(
                R.drawable.ic_tour,
                R.id.navigation_chat,
                ID_MESSAGE,
                R.string.title_chat,
                R.string.empty_value
            ),
            Model(
                R.drawable.ic_courses,
                R.id.navigation_courses,
                ID_NOTIFICATION,
                R.string.title_notifications,
                R.string.empty_value
            ),
            Model(
                R.drawable.ic_notification,
                R.id.navigation_profile,
                ID_ACCOUNT,
                R.string.title_profile,
                R.string.empty_value
            )
        )

        binding.bottomNavigation.apply {
            setMenuItems(menuItems, activeIndex)
            setupWithNavController(navController, exitOnBack = false)

            setOnClickMenuListener { item ->
                // Ensure the correct destination is navigated to
                navController.navigate(item.destinationId)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("activeIndex", binding.bottomNavigation.getSelectedIndex())
        super.onSaveInstanceState(outState)
    }
}
