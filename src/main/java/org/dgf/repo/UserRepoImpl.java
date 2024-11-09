package org.dgf.repo;

import org.dgf.user.Administrator;
import org.dgf.user.NormalUser;
import org.dgf.user.User;
import org.dgf.util.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserRepoImpl implements UserRepo{
    private final Map<String, User> users;
    private String logonUser = "";

    public UserRepoImpl() {
        this.users = new HashMap<>();
    }

    public UserRepoImpl(Map<String, User> users) {
        this.users = users;
    }

    public boolean exist(String name, String password) {
        return this.users.containsKey(name) && this.users.get(name).getPassword().equals(password);
    }

    public boolean add(String name, String password, String type) {
        if (name.isEmpty() || password.isEmpty() || this.users.containsKey(name)) {
            Logger.warn("Either name or password is empty, or user already exist");
            return false;
        }
        User user;
        if (type.equalsIgnoreCase("admin")) {
            user = new Administrator(name, password);
        }
        else {
            user = new NormalUser(name, password);
        }

        this.users.put(name, user);

        return true;
    }

    public Optional<User> find(String name) {
        return Optional.ofNullable(this.users.get(name));
    }

    public void login(String name) {
        this.logonUser = name;
    }

    public boolean isLogin(String name) {
        return this.logonUser.equals(name);
    }

    public String getLogonUser() {
        return this.logonUser;
    }
}
