package org.dgf.service.action;

import org.dgf.repo.BookRepo;
import org.dgf.service.Authenticator;
import org.dgf.util.Logger;

import java.util.List;

public class BorrowBook extends BookAction {

    public BorrowBook(Authenticator authenticator, BookRepo bookRepo) {
        super(authenticator, bookRepo);
    }

    @Override
    public void execute(List<String> arguments) {
        if(arguments.size() != 3) {
            Logger.warn("Not enough arguments for borrow book");
        }
        String book = arguments.get(1);
        String author = arguments.get(2);
        String user = this.authenticator.getLogonUser();
        super.bookRepo.borrow(user, book, author);
    }
}
