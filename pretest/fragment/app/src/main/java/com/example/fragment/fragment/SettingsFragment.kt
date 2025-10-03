package com.example.fragment.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Switch
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.fragment.MainActivity
import com.example.fragment.R
import com.example.fragment.data.FilterConfig

class SettingsFragment : Fragment() {
    companion object {
        fun newInstance() = SettingsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_settings, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        view.findViewById<Switch>(R.id.switchOnlyFavorite).setOnCheckedChangeListener { _, isChecked ->
//            Toast.makeText(requireContext(), "Only Favorite: $isChecked (mock)", Toast.LENGTH_SHORT).show()
//        }
        val switch = view.findViewById<Switch>(R.id.switchOnlyFavorite)
        switch.isChecked = FilterConfig.showOnlyFavorite

        switch.setOnCheckedChangeListener { _, isChecked ->
            FilterConfig.showOnlyFavorite = isChecked
            Toast.makeText(requireContext(), "Only Favorite: $isChecked", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<Button>(R.id.btnBackHome).setOnClickListener {
            (requireActivity() as MainActivity).navigateTo(
                HomeFragment.newInstance(),
                addToBackStack = false
            )
        }
    }
}