package org.dgf.repo;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookRepoTest {
    @Test
    public void TestAddBook_WhenBookIsNew(){
        final BookRepo bookRepo = new BookRepoImpl();
        final String name = "Atomic Habits", author = "James Clear";
        final int inventory = 10;
        bookRepo.add(name, inventory, author);

        Optional<BookInfo> bookInfo = bookRepo.find(name, author);
        assertTrue(bookInfo.isPresent());
        assertEquals(inventory, bookInfo.get().getInventory());
    }

    @Test
    public void TestAddBook_WhenBookIsStored(){
        final BookRepo bookRepo = new BookRepoImpl();
        final String book = "Atomic Habits", author = "James Clear";
        final int inventory = 10, updated = 5;
        bookRepo.add(book, inventory, author);
        bookRepo.add(book, updated, author);
        Optional<BookInfo> bookInfo = bookRepo.find(book, author);
        assertTrue(bookInfo.isPresent());
        assertEquals(inventory+updated, bookInfo.get().getInventory());
    }

    @Test
    public void TestListBook(){
        final BookRepo bookRepo = new BookRepoImpl();
        final String book1 = "Atomic Habits", book2 = "The World For Sale", author = "James Clear";
        final int inventory1 = 10, inventory2 = 5;
        bookRepo.add(book1, inventory1, author);
        bookRepo.add(book2, inventory2, author);
        bookRepo.list();
    }

    @Test
    public void TestBorrowBook_WhenStoreEnough(){
        final BookRepo bookRepo = new BookRepoImpl();
        final String book = "Atomic Habits", user = "Wang", author = "James Clear";
        final int inventory = 10;
        bookRepo.add(book, inventory, author);

        boolean borrowed = bookRepo.borrow(user, book, author);
        assertTrue(borrowed);

        Optional<BookInfo> bookInfo = bookRepo.find(book, author);
        assertTrue(bookInfo.isPresent());
        assertEquals(inventory-1, bookInfo.get().getInventory());
        assertTrue(bookInfo.get().getBorrowedByWho().contains(user));
    }

    @Test
    public void TestBorrowBook_WhenStoreNotEnough(){
        final BookRepo bookRepo = new BookRepoImpl();
        final String book = "Atomic Habits", user = "Wang", user2 = "Li" , author = "James Clear";
        final int inventory = 1;
        bookRepo.add(book, inventory, author);

        boolean succeed = bookRepo.borrow(user, book, author);
        assertTrue(succeed);

        Optional<BookInfo> bookInfo = bookRepo.find(book, author);
        assertTrue(bookInfo.isPresent());
        assertEquals(inventory-1, bookInfo.get().getInventory());
        assertTrue(bookInfo.get().getBorrowedByWho().contains(user));

        boolean failed = bookRepo.borrow(user, book, author);
        assertTrue(!failed);
    }

    @Test
    public void BookIsDeleted_WhenNoOneBorrowed(){
        final BookRepo bookRepo = new BookRepoImpl();
        final String book = "Atomic Habits", author = "James Clear";
        final int inventory = 10;
        bookRepo.add(book, inventory, author);
        bookRepo.delete(book, author);
        Optional<BookInfo> bookInfo = bookRepo.find(book, author);
        assertTrue(bookInfo.isEmpty());
    }

    @Test
    public void BookIsNotDeleted_WhenIsBorrowed(){
        final BookRepo bookRepo = new BookRepoImpl();
        final String book = "Atomic Habits", user = "Wang", author = "James Clear";
        final int inventory = 10;
        bookRepo.add(book, inventory, author);
        bookRepo.borrow(user, book, author);

        boolean failed = bookRepo.delete(book, author);
        assertTrue(!failed);
    }

    @Test
    public void TestReturnBook(){
        final BookRepo bookRepo = new BookRepoImpl();
        final String book = "Atomic Habits", user = "Wang", user2 = "Li", author = "James Clear";
        final int inventory = 10;
        bookRepo.add(book, inventory, author);

        boolean succeed1 = bookRepo.borrow(user, book, author);
        assertTrue(succeed1);

        boolean succeed2 = bookRepo.borrow(user2, book, author);
        assertTrue(succeed2);

        Optional<BookInfo> bookInfo = bookRepo.find(book, author);
        assertTrue(bookInfo.isPresent());
        assertEquals(inventory-2, bookInfo.get().getInventory());
        assertTrue(bookInfo.get().getBorrowedByWho().contains(user));
        assertTrue(bookInfo.get().getBorrowedByWho().contains(user2));

        bookRepo.returnBook(user, book, author);
        Optional<BookInfo> newInfo = bookRepo.find(book, author);
        assertTrue(newInfo.isPresent());
        assertEquals(inventory-1, newInfo.get().getInventory());
        assertTrue(!newInfo.get().getBorrowedByWho().contains(user));
        assertTrue(newInfo.get().getBorrowedByWho().contains(user2));
    }
}
