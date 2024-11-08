package org.dgf.service;

import org.dgf.repo.BookRepo;

public class BookLibFunctionsImpl implements BookLibFunctions{
    private final BookRepo bookRepo;

    public BookLibFunctionsImpl(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public void listBooks() {

    }

    @Override
    public boolean searchBook(String bookName) {
        return false;
    }

    @Override
    public void addBook(String bookName, int inventory) {

    }

    @Override
    public boolean borrowBook(String bookName) {
        return false;
    }

    @Override
    public void returnBook(String bookName) {

    }

    @Override
    public boolean deleteBook(String bookName) {
        return false;
    }
}
