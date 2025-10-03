package com.example.fragment.data

data class Book(
    val title: String,
    val author: String,
    val isFavorite: Boolean
)

object MockBooks {
    val items: List<Book> = listOf(
        Book("Clean Code", "Robert C. Martin", true),
        Book("Kotlin in Action", "Dmitry Jemerov", false),
        Book("Android Apprentice", "raywenderlich Team", true),
        Book("public test", "mike", true)
    )
}

object FilterConfig{
    var showOnlyFavorite: Boolean = false
}