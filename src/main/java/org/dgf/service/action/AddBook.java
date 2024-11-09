package org.dgf.service.action;

import org.dgf.repo.BookRepo;
import org.dgf.service.Authenticator;
import org.dgf.util.Logger;

import java.util.List;

public class AddBook extends BookAction {

    public AddBook(Authenticator authenticator, BookRepo bookRepo) {
        super(authenticator, bookRepo);
    }

    @Override
    public void execute(List<String> arguments) {
        if (! super.authenticator.isAdmin()) {
            Logger.warn("User " + super.authenticator.getLogonUser() + " is not admin");
            return;
        }
        if (arguments.size() != 3) {
            return;
        }
        String book = arguments.get(1);
        String inventory = arguments.get(2);
        super.bookRepo.add(book, Integer.parseInt(inventory));
    }
}
