package org.dgf.service.action;

import org.dgf.repo.BookRepo;
import org.dgf.service.Authenticator;

import java.util.List;

public class DeleteBook extends BookAction {
    public DeleteBook(Authenticator authenticator, BookRepo bookRepo) {
        super(authenticator, bookRepo);
    }

    @Override
    public void execute(List<String> arguments) {

    }
}
