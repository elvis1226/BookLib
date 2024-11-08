package org.dgf;

import org.dgf.repo.BookRepo;
import org.dgf.service.*;

public class Config {

    public static BookLibManager assemble() {
        Authenticator authenticator = new AuthenticatorImpl();
        BookRepo bookRepo = BookRepo.creatBookRepo();
        BookLibFunctions functions = new BookLibFunctionsImpl(bookRepo);
        BookLibManager manager = new BookLibManagerImpl(functions, authenticator);
        return manager;
    }
}
