package org.dgf.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    @Test
    public void TestAdminUser(){
        User user = new Administrator("wang", "124");
        assertTrue(user instanceof Administrator);
    }

    @Test
    public void TestNormalUser(){
        User user = new NormalUser("wang", "124");
        assertTrue(user instanceof NormalUser);
    }
}
