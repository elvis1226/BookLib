package org.dgf.user;

public class NormalUser extends User{
    public NormalUser(String name, String password) {
        super(name, password);
    }
    @Override
    public String toString() {
        return "User " + super.toString();
    }

}
