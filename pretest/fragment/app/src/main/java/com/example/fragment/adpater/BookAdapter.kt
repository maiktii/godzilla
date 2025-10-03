package com.example.fragment.adpater

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fragment.R
import com.example.fragment.data.Book

class BookAdapter (
    private val books: List<Book>,
    private val onItemClick: (position: Int) -> Unit
) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    inner class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        private val tvAuthor: TextView = itemView.findViewById(R.id.tvAuthor)

//        private val tvFavorite : TextView = itemView.findViewById(R.id.tvFavorite)

        fun bind(book: Book) {
            tvTitle.text = book.title
            tvAuthor.text = "by ${book.author}"
//            if (book.isFavorite) {
//                tvFavorite.visibility = View.VISIBLE
//                tvFavorite.text = "⭐ Favorite"
//            } else {
//                tvFavorite.visibility = View.GONE
//            }
            itemView.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_book, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(books[position])
    }

    override fun getItemCount(): Int = books.size
}