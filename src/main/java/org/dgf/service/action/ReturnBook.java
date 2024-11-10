package org.dgf.service.action;

import org.dgf.repo.BookRepo;
import org.dgf.service.Authenticator;
import org.dgf.util.Logger;

import java.util.List;

public class ReturnBook extends BookAction {
    public ReturnBook(Authenticator authenticator, BookRepo bookRepo) {
        super(authenticator, bookRepo);
    }

    @Override
    public void execute(List<String> arguments) {
        if(arguments.size() != 3) {
            Logger.warn("Not enough arguments for return book");
        }
        String book = arguments.get(1);
        String author = arguments.get(2);
    }
}
