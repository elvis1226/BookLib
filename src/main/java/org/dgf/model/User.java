package org.dgf.model;

import java.util.Objects;

public class User {
    private final String name;
    private final String password;
    private final UserType type;

    private final static User anonymous = new User("anonymous", "", UserType.ANONYMOUS);

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.type = UserType.USER;
    }

    public User(String name, String password, UserType type) {
        this.name = name;
        this.password = password;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public UserType getType() {
        return type;
    }

    public static User anonymous() {
        return anonymous;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(password, user.password) && type == user.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password, type);
    }
}
