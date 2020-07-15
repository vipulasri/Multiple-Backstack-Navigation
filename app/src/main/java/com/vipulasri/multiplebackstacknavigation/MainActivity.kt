package com.vipulasri.multiplebackstacknavigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vipulasri.multiplebackstacknavigation.ui.BottomNavManager

class MainActivity : AppCompatActivity() {

  private var bottomNavManager: BottomNavManager? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    setupNavigationManager()
  }

  private fun setupNavigationManager() {
    bottomNavManager?.setupNavController() ?: kotlin.run {
      bottomNavManager = BottomNavManager(
          fragmentManager = supportFragmentManager,
          containerId = R.id.nav_host_fragment,
          bottomNavigationView = findViewById(R.id.nav_view)
      )
    }
  }

  override fun onSaveInstanceState(outState: Bundle) {
    super.onSaveInstanceState(outState)
    bottomNavManager?.onSaveInstanceState(outState)
  }

  override fun onRestoreInstanceState(savedInstanceState: Bundle) {
    super.onRestoreInstanceState(savedInstanceState)
    bottomNavManager?.onRestoreInstanceState(savedInstanceState)
    setupNavigationManager()
  }

  override fun onBackPressed() {
    if (bottomNavManager?.onBackPressed() == false) super.onBackPressed()
  }

}