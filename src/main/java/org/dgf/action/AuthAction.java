package org.dgf.action;

import org.dgf.repo.BookRepo;
import org.dgf.repo.UserRepo;
import org.dgf.service.Authenticator;

import java.util.List;

public abstract class AuthAction {
    protected final Authenticator authenticator;
    protected final UserRepo userRepo;

    public AuthAction(Authenticator authenticator, UserRepo userRepo) {
        this.authenticator = authenticator;
        this.userRepo = userRepo;
    }

    public abstract void execute(List<String> arguments);
}
