package org.dgf.service;

import org.dgf.model.User;
import org.dgf.repo.LoginStatus;
import org.dgf.repo.UserRepo;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public interface Authenticator {
    boolean register(String name, String password, String type);
    boolean login(String name, String password);
}
