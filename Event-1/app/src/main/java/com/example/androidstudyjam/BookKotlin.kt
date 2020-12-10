package com.example.androidstudyjam

class Book(
    var name: String?,
    var authorName: String?,
    var lastModifiedTimeStamp: Long,
    var rating: Float,
    var downloads: Int
) {

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as Book
        if (downloads != that.downloads) return false
        return if (name != that.name) {
            false
        } else authorName == that.authorName
    }

    override fun hashCode(): Int {
        var result = if (name != null) name.hashCode() else 0
        result = 31 * result + if (authorName != null) authorName.hashCode() else 0
        result = 31 * result + downloads
        return result
    }

    override fun toString(): String {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + authorName + '\'' +
                ", lastModifiedTimestamp='" + lastModifiedTimeStamp + '\'' +
                ", rating='" + rating + '\'' +
                ", downloads=" + downloads +
                '}'
    }

}

