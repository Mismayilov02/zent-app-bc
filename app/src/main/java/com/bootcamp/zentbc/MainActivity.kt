package com.bootcamp.zentbc

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.bootcamp.zentbc.databinding.ActivityMainBinding
import com.bootcamp.zentbc.fragments.BottomMenuListener

class MainActivity : AppCompatActivity(), BottomMenuListener {
//    private var navController: NavController? = null
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navController = (binding.fragmentContainerView.getFragment() as NavHostFragment).navController
        navController.setGraph(R.navigation.app_base_navigation)
        binding.bottomMenu.setupWithNavController(navController)
    }

    fun showToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun bottomMenuVisibility(visibility: Boolean) {
        binding.bottomMenu.visibility = if (visibility) VISIBLE else GONE
    }
}