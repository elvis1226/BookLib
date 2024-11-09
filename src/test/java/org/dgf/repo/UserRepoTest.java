package org.dgf.repo;

import org.dgf.user.NormalUser;
import org.dgf.user.User;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserRepoTest {

    @Test
    public void Given_UserNotExist_ThenAdd() {
        Map<String, User> users = new HashMap<>();
        users.put("Wang", new NormalUser("Wang","123"));
        UserRepo userRepo = new UserRepoImpl(users);
        boolean isAdded = userRepo.add("Zhang", "124", "user");
        assertTrue(isAdded);
    }

    @Test
    public void Given_UserExist_ThenNoAdd() {
        Map<String, User> users = new HashMap<>();
        users.put("Wang", new NormalUser("Wang","123"));
        UserRepo userRepo = new UserRepoImpl(users);
        boolean isAdded = userRepo.add("Wang", "123", "user");
        assertTrue(!isAdded);
    }

    @Test
    public void Given_UserNamePasswordMatch_ThenExist() {
        Map<String, User> users = new HashMap<>();
        users.put("Wang", new NormalUser("Wang","123"));
        UserRepo userRepo = new UserRepoImpl(users);
        boolean existed = userRepo.exist("Wang", "123");
        assertTrue(existed);
    }

    @Test
    public void Given_UserNamePasswordNotMatch_ThenNotExist() {
        Map<String, User> users = new HashMap<>();
        users.put("Wang", new NormalUser("Wang","123"));
        UserRepo userRepo = new UserRepoImpl(users);
        boolean existed = userRepo.exist("Wang", "122");
        assertTrue(!existed);
    }

    @Test
    public void FoundUser_WhenUserExist() {
        Map<String, User> users = new HashMap<>();
        users.put("Wang", new NormalUser("Wang","123"));
        UserRepo userRepo = new UserRepoImpl(users);
        Optional<User> optUser = userRepo.find("Wang");
        assertTrue(optUser.isPresent());
        assertEquals(optUser.get().getName(), "Wang");
    }

    @Test
    public void NotFoundUser_WhenUserNotExist() {
        Map<String, User> users = new HashMap<>();
        users.put("Wang", new NormalUser("Wang","123"));
        UserRepo userRepo = new UserRepoImpl(users);
        Optional<User> optUser = userRepo.find("Ya");
        assertTrue(optUser.isEmpty());
    }
}
