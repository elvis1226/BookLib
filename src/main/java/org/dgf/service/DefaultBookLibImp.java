package org.dgf.service;

import org.dgf.model.Book;
import org.dgf.model.User;
import org.dgf.repo.BookRepo;
import org.dgf.repo.UserRepo;

import java.util.HashMap;
import java.util.Map;

public class DefaultBookLibImp implements BookLib{
    private BookRepo bookRepo;
    public UserRepo userRepo;

    public DefaultBookLibImp() {
        new DefaultBookLibImp(new BookRepo(), new UserRepo());
    }

    public DefaultBookLibImp(BookRepo bookRepo, UserRepo userRepo) {
        this.bookRepo = bookRepo;
        this.userRepo = userRepo;
    }

    @Override
    public boolean login(String user, String password) {
        return false;
    }

    @Override
    public boolean register(String user, String password) {
        return false;
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
