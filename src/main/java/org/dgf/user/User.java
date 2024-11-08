package org.dgf.user;

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

}
