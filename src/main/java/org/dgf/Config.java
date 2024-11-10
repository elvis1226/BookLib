package org.dgf;

import org.dgf.flow.BookLibManager;
import org.dgf.flow.BookLibManagerImpl;
import org.dgf.repo.BookRepo;
import org.dgf.repo.BookRepoImpl;
import org.dgf.repo.UserRepo;
import org.dgf.repo.UserRepoImpl;
import org.dgf.service.*;

public final class Config {
    private Config() {

    }

    public static BookLibManager assemble() {

        UserRepo userRepo = new UserRepoImpl();
        BookRepo bookRepo = new BookRepoImpl();

        Authenticator authenticator = new AuthenticatorImpl(userRepo);
        BookOperator operator = new BookOperatorImpl(authenticator, bookRepo);

        BookLibManager manager = new BookLibManagerImpl(operator, authenticator);

        return manager;
    }
}
