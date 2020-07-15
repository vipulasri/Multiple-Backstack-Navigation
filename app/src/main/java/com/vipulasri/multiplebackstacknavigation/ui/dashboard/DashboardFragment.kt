package com.vipulasri.multiplebackstacknavigation.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.vipulasri.multiplebackstacknavigation.R

class DashboardFragment : Fragment() {

  private val dashboardViewModel: DashboardViewModel by viewModels()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_dashboard, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val textView: TextView = view.findViewById(R.id.text_dashboard)
    val button: Button = view.findViewById(R.id.button)

    button.setOnClickListener {
      findNavController().navigate(R.id.action_first_screen)
    }

    dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
      textView.text = it
    })
    
  }

}