package org.dgf.action;

import org.dgf.repo.BookRepo;
import org.dgf.repo.UserRepo;
import org.dgf.service.Authenticator;
import org.dgf.user.User;
import org.dgf.util.Logger;

import java.util.List;
import java.util.Optional;

public class Register extends AuthAction {
    public Register(Authenticator authenticator, UserRepo userRepo) {
        super(authenticator, userRepo);
    }

    @Override
    public void execute(List<String> arguments) {
        if (arguments.size() != 4) {
            return;
        }
        String name = arguments.get(2);
        String type = arguments.get(1);
        String password = arguments.get(3);

        if (super.userRepo.add(name, password, type)) {
            Optional<User> user = this.userRepo.find(name);
            Logger.info(user.get().toString() + " successfully registered.");
        }
    }
}
