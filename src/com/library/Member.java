package com.library;

import com.library.Book;
import java.util.UUID;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

class Member {
    private String id;
    private String name;
    private List<Book> borrowedBooks;

    public Member( String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {

        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }


    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }
}
