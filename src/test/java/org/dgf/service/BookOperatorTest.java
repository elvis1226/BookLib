package org.dgf.service;

import org.dgf.repo.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
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
        List<String> arguAdminLogin = List.of("login", "Wang", "123");

        this.authenticator.process(arguAdmin);
        this.authenticator.process(arguUser);
        authenticator.process(arguAdminLogin);
    }

    @Test
    public void TestOperator_AddAction(){

        BookOperator operator = new BookOperatorImpl(authenticator, bookRepo);
        String book = "Cool Guy", author = "Wo";
        List<String> arguAddBook = List.of("add", book, author, "10");
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
        String book1 = "Cool Guy", book2 = "Cool Girl", inventory = "10", author = "Wo";
        List<String> arguAddBook1 = List.of("add", book1, author, inventory);
        List<String> arguAddBook2 = List.of("add", book2, author, inventory);
        operator.process(arguAddBook1);
        operator.process(arguAddBook2);

        operator.process(List.of("list"));
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
