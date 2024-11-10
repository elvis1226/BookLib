package org.dgf.service;

import org.dgf.repo.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookOperatorTest {
    private UserRepo userRepo;
    private BookRepo bookRepo;
    private Authenticator authenticator;

    @BeforeEach
    public void setup(){
        this.userRepo = new UserRepoImpl();
        this.bookRepo = new BookRepoImpl();
        this.authenticator = new AuthenticatorImpl(userRepo);
        List<String> arguAdmin = List.of("register", "admin", "Wang", "123");
        List<String> arguUser = List.of("register", "user", "Li", "123");

        this.authenticator.process(arguAdmin);
        this.authenticator.process(arguUser);
    }

    @Test
    public void TestOperator_AddAction(){
        List<String> arguAdminLogin = List.of("login", "Wang", "123");
        authenticator.process(arguAdminLogin);

        BookOperator operator = new BookOperatorImpl(authenticator, bookRepo);
        String book = "Cool Guy";
        List<String> arguAddBook = List.of("add", book, "10");
        operator.process(arguAddBook);
        Optional<BookInfo> bookInfo = this.bookRepo.find(book);
        assertTrue(bookInfo.isPresent());
        assertEquals(10, bookInfo.get().getInventory());
    }

    @Test
    public void TestOperator_DeleteAction(){
        BookOperator operator = new BookOperatorImpl(authenticator, bookRepo);

    }

    @Test
    public void TestOperator_ListAction(){
        BookOperator operator = new BookOperatorImpl(authenticator, bookRepo);

    }

    @Test
    public void TestOperator_BorrowAction(){
        BookOperator operator = new BookOperatorImpl(authenticator, bookRepo);

    }

    @Test
    public void TestOperator_ReturnAction(){
        BookOperator operator = new BookOperatorImpl(authenticator, bookRepo);

    }

    @Test
    public void TestOperator_SearchAction(){
        BookOperator operator = new BookOperatorImpl(authenticator, bookRepo);

    }

}
