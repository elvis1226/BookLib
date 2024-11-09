package org.dgf.service.action;

import org.dgf.repo.BookRepo;
import org.dgf.service.Authenticator;

import java.util.List;

public abstract class BookAction {
    protected final Authenticator authenticator;
    protected final BookRepo bookRepo;

    public BookAction(Authenticator authenticator, BookRepo bookRepo) {
        this.authenticator = authenticator;
        this.bookRepo = bookRepo;
    }

    public abstract void execute(List<String> arguments);
}
