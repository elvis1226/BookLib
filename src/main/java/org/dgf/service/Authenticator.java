package org.dgf.service;

public interface Authenticator {
    boolean register(String name, String password, String type);
    boolean login(String name, String password);
}
