package org.dgf.service;

import org.dgf.repo.UserRepo;
import org.dgf.service.action.AuthAction;
import org.dgf.service.action.Login;
import org.dgf.service.action.Register;
import org.dgf.user.Administrator;
import org.dgf.user.User;
import org.dgf.util.Logger;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class AuthenticatorImpl implements Authenticator{
    private final UserRepo userRepo;
    private final Map<String, AuthAction> actions;

    public AuthenticatorImpl(UserRepo userRepo) {
        this.userRepo = userRepo;

        this.actions = Map.of("login",    new Login(this, this.userRepo),
                              "register", new Register(this, this.userRepo));
    }

    public boolean isLogin(String name) {
        return this.userRepo.isLogin(name);
    }

    public boolean isAdmin(){
        return isAdmin(this.userRepo.getLogonUser());
    }

    public boolean isAdmin(String name) {
        Optional<User> optUser = this.userRepo.find(name);
        if(optUser.isEmpty()) {
            return false;
        }
        User user = optUser.get();
        if (user instanceof Administrator) {
            return true;
        }
        return false;
    }

    public String getLogonUser() {
        return this.userRepo.getLogonUser();
    }

    @Override
    public void process(List<String> arguments) {
        String command = arguments.get(0);
        Logger.debug("process auth command " + command);
        this.actions.get(command).execute(arguments);
    }
}
