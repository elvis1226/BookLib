package org.dgf.repo;

import org.dgf.model.User;
import org.dgf.model.UserType;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserRepoTest {

    @Test
    public void Given_UserNotExist_ThenAdd() {
        Map<String, User> users = new HashMap<>();
        users.put("Wang", new User("Wang","123"));
        UserRepo userRepo = new UserRepo(users);
        boolean isAdded = userRepo.add("Zhang", "124", UserType.USER.toString());
        assertTrue(isAdded);
    }

    @Test
    public void Given_UserExist_ThenNoAdd() {
        Map<String, User> users = new HashMap<>();
        users.put("Wang", new User("Wang","123"));
        UserRepo userRepo = new UserRepo(users);
        boolean isAdded = userRepo.add("Wang", "123", UserType.USER.toString());
        assertTrue(!isAdded);
    }

    @Test
    public void Given_UserNamePasswordMatch_ThenExist() {
        Map<String, User> users = new HashMap<>();
        users.put("Wang", new User("Wang","123"));
        UserRepo userRepo = new UserRepo(users);
        boolean existed = userRepo.exist("Wang", "123");
        assertTrue(existed);
    }

    @Test
    public void Given_UserNamePasswordNotMatch_ThenNotExist() {
        Map<String, User> users = new HashMap<>();
        users.put("Wang", new User("Wang","123"));
        UserRepo userRepo = new UserRepo(users);
        boolean existed = userRepo.exist("Wang", "122");
        assertTrue(!existed);
    }
}
