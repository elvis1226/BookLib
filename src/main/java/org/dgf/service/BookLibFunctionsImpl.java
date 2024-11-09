package org.dgf.service;

import org.dgf.action.*;
import org.dgf.repo.BookRepo;

import java.util.List;
import java.util.Map;

public class BookLibFunctionsImpl implements BookLibFunctions{
    private final Map<String, BookAction> actions;

    private final Authenticator authenticator;
    private final BookRepo bookRepo;

    public BookLibFunctionsImpl(Authenticator authenticator, BookRepo bookRepo) {
        this.authenticator = authenticator;
        this.bookRepo = bookRepo;
        this.actions = buildActions();
    }

    @Override
    public void process(List<String> arguments) {
        String command = arguments.get(0);
        this.actions.get(command).execute(arguments);

    }

    private Map<String, BookAction> buildActions() {
          return Map.of(
                "add",    new AddBook(authenticator, bookRepo),
                "delete", new DeleteBook(authenticator, bookRepo),
                "search", new SearchBook(authenticator, bookRepo),
                "list",   new ListBook(authenticator, bookRepo),
                "borrow", new BorrowBook(authenticator, bookRepo),
                "return", new ReturnBook(authenticator, bookRepo));
    }

}
