package org.dgf.repo;

import org.dgf.user.User;
import org.dgf.user.UserType;

import java.util.HashMap;
import java.util.Map;

public class UserRepoImpl implements UserRepo{
    private final Map<String, User> users;

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
            return false;
        }
        UserType userType = UserType.valueOf(type.toUpperCase());
        User user = new User(name, password, userType);
        this.users.put(name, user);

        return true;
    }
}
