package com.example.fragment.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragment.MainActivity
import com.example.fragment.R
import com.example.fragment.adpater.BookAdapter
import com.example.fragment.data.FilterConfig
import com.example.fragment.data.MockBooks


class HomeFragment : Fragment() {
    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        val listView = view.findViewById<ListView>(R.id.listViewBooks)
        val recyclerView = view.findViewById<RecyclerView>(R.id.rvListBook)

//        val titles = MockBooks.items.map { it.title }
//        listView.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, titles)
//
//        listView.setOnItemClickListener { _, _, position, _ ->
//            (requireActivity() as MainActivity).navigateTo(
//                DetailFragment.newInstance(position),
//                addToBackStack = true
//            )
//        }
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val books = if (FilterConfig.showOnlyFavorite) {
            MockBooks.items.filter { it.isFavorite }
        } else {
            MockBooks.items
        }
        recyclerView.adapter = BookAdapter(books) { position ->
            (requireActivity() as MainActivity).navigateTo(
                DetailFragment.newInstance(position),
                addToBackStack = true
            )
        }

        view.findViewById<View>(R.id.btnOpenSettings).setOnClickListener {
            (requireActivity() as MainActivity).navigateTo(
                SettingsFragment.newInstance(),
                addToBackStack = true
            )
        }
    }
}