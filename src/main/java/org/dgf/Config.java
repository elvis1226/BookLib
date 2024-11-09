package org.dgf;

import org.dgf.repo.BookRepo;
import org.dgf.repo.BookRepoImpl;
import org.dgf.repo.UserRepo;
import org.dgf.repo.UserRepoImpl;
import org.dgf.service.*;

public class Config {

    public static BookLibManager assemble() {

        UserRepo userRepo = new UserRepoImpl();
        BookRepo bookRepo = new BookRepoImpl();

        Authenticator authenticator = new AuthenticatorImpl(userRepo);
        BookLibFunctions functions = new BookLibFunctionsImpl(bookRepo);

        BookLibManager manager = new BookLibManagerImpl(functions, authenticator);

        return manager;
    }
}
