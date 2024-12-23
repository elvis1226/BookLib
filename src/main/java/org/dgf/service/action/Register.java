package org.dgf.service.action;

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
            Logger.warn("argument is not enough to run register");
            return;
        }
        Logger.debug("execute register");
        String name = arguments.get(2);
        String type = arguments.get(1);
        String password = arguments.get(3);
        Logger.debug("name " + name + ", type" + type + ", password " + password );
        if (super.userRepo.add(name, password, type)) {
            Optional<User> user = this.userRepo.find(name);
            Logger.info(user.get().toString() + " successfully registered.");
        }
        else {
            Logger.debug("failed to add user");
        }
    }
}
