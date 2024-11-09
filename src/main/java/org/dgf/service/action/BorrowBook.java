package org.dgf.service.action;

import org.dgf.repo.BookRepo;
import org.dgf.service.Authenticator;

import java.util.List;

public class BorrowBook extends BookAction {
    public BorrowBook(Authenticator authenticator, BookRepo bookRepo) {
        super(authenticator, bookRepo);
    }

    @Override
    public void execute(List<String> arguments) {

    }
}
