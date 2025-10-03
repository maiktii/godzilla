package com.example.fragment.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.fragment.MainActivity
import com.example.fragment.R
import com.example.fragment.data.MockBooks

class DetailFragment : Fragment() {
    companion object {
        private const val ARG_INDEX = "arg_index"

        fun newInstance(index: Int) = DetailFragment().apply {
            arguments = Bundle().apply { putInt(ARG_INDEX, index) }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_detail, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val idx = arguments?.getInt(ARG_INDEX) ?: -1
        val book = MockBooks.items.getOrNull(idx)

        view.findViewById<TextView>(R.id.tvTitle).text = book?.title ?: "Unknown"
        view.findViewById<TextView>(R.id.tvAuthor).text = "by ${book?.author ?: "-"}"

        if (book?.isFavorite == true) {
            view.findViewById<TextView>(R.id.tvFavorite).text = "Buku Ini Favorit"
        } else{
            view.findViewById<TextView>(R.id.tvFavorite).text = "Buku Ini Tidak Favorit"
        }


        view.findViewById<Button>(R.id.btnBackHome).setOnClickListener {
            (requireActivity() as MainActivity).navigateTo(HomeFragment.newInstance(), addToBackStack = false)
        }
    }
}