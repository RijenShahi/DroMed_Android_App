package com.rijen.dromedapp.ui.notifications

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rijen.dromedapp.MapsActivity
import com.rijen.dromedapp.R

class NotificationsFragment : Fragment() {

  private lateinit var notificationsViewModel: NotificationsViewModel
  private lateinit var btnMap : Button

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)
    val root = inflater.inflate(R.layout.fragment_notifications, container, false)
    val textView: TextView = root.findViewById(R.id.text_notifications)
    notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
      textView.text = it
    })
    btnMap = root.findViewById(R.id.btnMapViewer)
    btnMap.setOnClickListener {
      var intent = Intent(requireContext(),MapsActivity::class.java)
      startActivity(intent)
    }
    return root
  }
}