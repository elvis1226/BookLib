package org.dgf.repo;

import org.dgf.user.User;

import java.util.Optional;

public interface UserRepo {
    boolean exist(String name, String password);
    boolean add(String name, String password, String type);
    void login(String name);
    boolean isLogin(String name);
    Optional<User> find(String name);
    String getLogonUser();
}
