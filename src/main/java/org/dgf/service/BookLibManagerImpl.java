package org.dgf.service;


import org.dgf.repo.BookRepo;

import java.util.List;


public class BookLibManagerImpl implements BookLibManager {
    private BookLibFunctions functions;
    private Authenticator authenticator;

    public BookLibManagerImpl(BookLibFunctions functions, Authenticator authenticator) {
        this.functions = functions;
        this.authenticator = authenticator;
    }


    public boolean login(String user, String password) {
        return this.authenticator.login(user, password);
    }

    public boolean register(String user, String password, String type) {
        return this.authenticator.register(user, password, type);
    }

    @Override
    public void process(List<String> arguments) {

    }

}
