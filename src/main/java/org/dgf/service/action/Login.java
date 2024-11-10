package org.dgf.service.action;

import org.dgf.repo.UserRepo;
import org.dgf.service.Authenticator;
import org.dgf.user.User;
import org.dgf.util.Logger;

import java.util.List;
import java.util.Optional;

public class Login extends AuthAction {

    public Login(Authenticator authenticator, UserRepo userRepo) {
        super(authenticator, userRepo);
    }

    @Override
    public void execute(List<String> arguments) {
        if (arguments.size() != 3) {
            Logger.warn("Failed to login, pls check arguments");
            return;
        }
        String name = arguments.get(1);
        String password = arguments.get(2);

        if (!this.userRepo.exist(name, password)) {
            Logger.warn("Failed to login, user doest exist or incorrect user name/password");
            return;
        }
        this.userRepo.login(name);

        Optional<User> user = this.userRepo.find(name);
        Logger.info(user.get().toString() + " successfully logged in.");
    }
}
