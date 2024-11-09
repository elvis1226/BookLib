package org.dgf.user;

public class Administrator extends User{
    public Administrator(String name, String password) {
        super(name, password);
    }

    @Override
    public String toString() {
        return "Admin " + super.toString();
    }
}
