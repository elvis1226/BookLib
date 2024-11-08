package org.dgf.service;

import org.dgf.model.User;
import org.dgf.repo.LoginStatus;
import org.dgf.repo.UserRepo;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Authenticator {
    private final UserRepo userRepo;
    private Map<String, LoginStatus> userStatus;

    public Authenticator() {
        this.userRepo = new UserRepo();
        this.userStatus = new HashMap<>();
    }

    public boolean register(String name, String password, String type){
        return this.userRepo.add(name, password, type);
    }

    public boolean login(String name, String password) {
        if (!this.userRepo.exist(name, password)) {
            return false;
        }
        this.userStatus.put(name, LoginStatus.LOGON);

        return true;
    }

    public boolean isLogin(String name) {
        return this.userStatus.containsKey(name) && this.userStatus.get(name).equals(LoginStatus.LOGON);
    }
}
