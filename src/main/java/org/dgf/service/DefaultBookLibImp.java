package org.dgf.service;

import org.dgf.model.User;
import org.dgf.repo.BookRepo;

import java.util.Optional;

import static org.dgf.model.User.anonymous;


public class DefaultBookLibImp implements BookLib{
    private BookRepo bookRepo;
    private Authenticator authenticator;

    public DefaultBookLibImp() {
        new DefaultBookLibImp(new BookRepo(), new Authenticator());
    }

    public DefaultBookLibImp(BookRepo bookRepo, Authenticator authenticator) {
        this.bookRepo = bookRepo;
        this.authenticator = authenticator;
    }

    @Override
    public boolean login(String user, String password) {
        return this.authenticator.login(user, password);
    }

    @Override
    public boolean register(String user, String password, String type) {
        return this.authenticator.register(user, password, type);
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
