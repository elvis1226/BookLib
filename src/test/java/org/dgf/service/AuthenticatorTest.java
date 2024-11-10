package org.dgf.service;

import org.dgf.repo.UserRepo;
import org.dgf.repo.UserRepoImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuthenticatorTest {

    @Test
    public void TestRegisterUser(){
        UserRepo userRepo = new UserRepoImpl();
        Authenticator authenticator = new AuthenticatorImpl(userRepo);
        List<String> arguAdmin = List.of("register", "admin", "Wang", "123");
        List<String> arguUser = List.of("register", "user", "Li", "123");
        authenticator.process(arguAdmin);
        authenticator.process(arguUser);
        assertTrue(authenticator.isAdmin("Wang"));
        assertTrue(!authenticator.isAdmin("Li"));
    }

    @Test
    public void TestLoginUser(){
        UserRepo userRepo = new UserRepoImpl();
        Authenticator authenticator = new AuthenticatorImpl(userRepo);
        List<String> arguAdmin = List.of("register", "admin", "Wang", "123");
        List<String> arguUser = List.of("register", "user", "Li", "123");
        authenticator.process(arguAdmin);
        authenticator.process(arguUser);

        List<String> arguUserLogin = List.of("login", "Li", "123");
        authenticator.process(arguUserLogin);
        assertTrue(authenticator.isLogin("Li"));
        assertFalse(authenticator.isLogin("Wang"));
    }
}
