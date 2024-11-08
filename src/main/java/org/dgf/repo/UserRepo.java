package org.dgf.repo;

import org.dgf.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepo {
    private final Map<User, LoginStatus> users;

    public UserRepo() {
        this.users = new HashMap<>();
    }

    public boolean exist(String user) {
        return this.users.containsKey(user);
    }

    public boolean isLogin(String user) {
        return exist(user) && this.users.get(user).equals(LoginStatus.LOGON);
    }
}
