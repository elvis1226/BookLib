package org.dgf.service;

import org.dgf.repo.BookRepo;
import org.dgf.service.action.*;
import org.dgf.util.Logger;

import java.util.List;
import java.util.Map;

public class BookOperatorImpl implements BookOperator {
    private final Map<String, BookAction> actions;

    private final Authenticator authenticator;
    private final BookRepo bookRepo;

    public BookOperatorImpl(Authenticator authenticator, BookRepo bookRepo) {
        this.authenticator = authenticator;
        this.bookRepo = bookRepo;
        this.actions = buildActions();
    }

    @Override
    public void process(List<String> arguments) {
        String command = arguments.get(0);
        Logger.debug("process book lib command " + command);
        this.actions.get(command).execute(arguments);
    }

    @Override
    public boolean isDoable(String command) {
        return this.actions.containsKey(command);
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
