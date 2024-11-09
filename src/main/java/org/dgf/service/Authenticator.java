package org.dgf.service;

import java.util.List;

public interface Authenticator {
    boolean isAdmin(String name);
    boolean isLogin(String name);
    boolean isAdmin();
    String getLogonUser();
    void process(List<String> arguments);
}
