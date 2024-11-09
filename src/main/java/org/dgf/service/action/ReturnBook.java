package org.dgf.service.action;

import org.dgf.repo.BookRepo;
import org.dgf.service.Authenticator;

import java.util.List;

public class ReturnBook extends BookAction {
    public ReturnBook(Authenticator authenticator, BookRepo bookRepo) {
        super(authenticator, bookRepo);
    }

    @Override
    public void execute(List<String> arguments) {

    }
}
