package dev.theuzfaleiro.maybetoday

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import dev.theuzfaleiro.maybetoday.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity(R.layout.activity_home) {
    private lateinit var homeActivityHomeBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpBinding()
        setUpToolbar()
    }

    private fun setUpBinding() {
        homeActivityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
    }

    private fun setUpToolbar() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerViewHome) as NavHostFragment

        val navController = navHostFragment.navController

        homeActivityHomeBinding.toolbarHome.setupWithNavController(
            navHostFragment.navController,
            AppBarConfiguration(navController.graph)
        )
    }
}
