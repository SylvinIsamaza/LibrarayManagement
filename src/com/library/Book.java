package com.library;
import java.util.*;


public class Book {
    private String isbn;
    private String title;
    private String authors;
    private int publicationYear;
    private boolean isBorrowed;

    public Book( String title, String authors, int publicationYear) {
        this.isbn = UUID.randomUUID().toString();
        this.title = title;
        this.authors = authors;
        this.publicationYear = publicationYear;
        this.isBorrowed = false;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthors() {
        return authors;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    @Override
    public String toString() {
        return "ISBN: " + isbn + ", Title: " + title + ", Authors: " + authors + ", Year: " + publicationYear;
    }
}
