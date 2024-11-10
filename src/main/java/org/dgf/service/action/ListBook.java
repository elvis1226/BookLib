package org.dgf.service.action;

import org.dgf.repo.BookRepo;
import org.dgf.service.Authenticator;
import org.dgf.util.Logger;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class ListBook extends BookAction {
    public ListBook(Authenticator authenticator, BookRepo bookRepo) {
        super(authenticator, bookRepo);
    }

    @Override
    public void execute(List<String> arguments) {
        super.bookRepo.list();
    }
}
