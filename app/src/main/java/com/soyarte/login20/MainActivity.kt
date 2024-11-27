package com.soyarte.login20

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.soyarte.login20.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar toolbar
        setSupportActionBar(binding.toolbar)

        // Configurar el NavController principal
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as? NavHostFragment

        if (navHostFragment != null) {
            navController = navHostFragment.navController
            setupActionBarWithNavController(navController)
            setupDestinationChangedListener()
        } else {
            throw RuntimeException("NavHostFragment not found with ID R.id.nav_host_fragment")
        }
    }

    private fun setupDestinationChangedListener() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            Log.d("MainActivity", "Navigated to ${destination.label}")
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        // Permitir navegación hacia atrás en la barra de acción
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
