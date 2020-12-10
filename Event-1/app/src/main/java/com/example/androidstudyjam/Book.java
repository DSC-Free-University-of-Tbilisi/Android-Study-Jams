package com.example.androidstudyjam;


import java.util.Objects;

public class Book {
    private String name;
    private String authorName;
    private long lastModifiedTimeStamp;
    private float rating;
    private int downloads;


    public Book(String name, String authorName, long lastModified, float rating, int downloads) {
        this.name = name;
        this.authorName = authorName;
        this.lastModifiedTimeStamp = lastModified;
        this.rating = rating;
        this.downloads = downloads;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public long getLastModifiedTimeStamp() {
        return lastModifiedTimeStamp;
    }

    public void setLastModifiedTimeStamp(long lastModifiedTimeStamp) {
        this.lastModifiedTimeStamp = lastModifiedTimeStamp;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book that = (Book) o;

        if (downloads != that.downloads)
            return false;
        if (!Objects.equals(name, that.name)) {
            return false;
        }
        return Objects.equals(authorName, that.authorName);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (authorName != null ?
                authorName.hashCode() : 0);
        result = 31 * result + downloads;
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + authorName + '\'' +
                ", lastModifiedTimestamp='" + lastModifiedTimeStamp + '\'' +
                ", rating='" + rating + '\'' +
                ", downloads=" + downloads +
                '}';
    }
}

