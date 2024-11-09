package org.dgf.service;

import org.dgf.action.*;
import org.dgf.repo.BookRepo;

import java.util.List;
import java.util.Map;


public class BookLibFunctionsImpl implements BookLibFunctions{
    private Map<String, Class> actions = Map.of("add",    AddBook.class,
                                                             "delete", DeleteBook.class,
                                                             "search", SearchBook.class,
                                                             "list",   ListBook.class,
                                                             "borrow", BorrowBook.class,
                                                             "return", ReturnBook.class);

    private final Authenticator authenticator;
    private final BookRepo bookRepo;

    public BookLibFunctionsImpl(Authenticator authenticator, BookRepo bookRepo) {
        this.authenticator = authenticator;
        this.bookRepo = bookRepo;
    }

    @Override
    public void process(List<String> arguments) {
        String command = arguments.get(0);


    }

    private void buildActions() {

    }

}
