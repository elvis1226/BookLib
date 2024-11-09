package org.dgf.action;

import org.dgf.repo.BookRepo;
import org.dgf.service.Authenticator;

import java.util.List;

public class SearchBook extends BookAction {
    public SearchBook(Authenticator authenticator, BookRepo bookRepo, List<String> arguments) {
        super(authenticator, bookRepo);
    }

    @Override
    public void execute(List<String> arguments) {

    }
}
