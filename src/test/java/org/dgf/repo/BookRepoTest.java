package org.dgf.repo;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookRepoTest {
    @Test
    public void TestAddBook_WhenBookIsNew(){
        final BookRepo bookRepo = new BookRepoImpl();
        final String book = "Atomic Habits";
        final int inventory = 10;
        bookRepo.add(book, inventory);
        Optional<BookInfo> bookInfo = bookRepo.find(book);
        assertTrue(bookInfo.isPresent());
        assertEquals(inventory, bookInfo.get().getInventory());
    }

    @Test
    public void TestAddBook_WhenBookIsStored(){
        final BookRepo bookRepo = new BookRepoImpl();
        final String book = "Atomic Habits";
        final int inventory = 10, updated = 5;
        bookRepo.add(book, inventory);
        bookRepo.add(book, updated);
        Optional<BookInfo> bookInfo = bookRepo.find(book);
        assertTrue(bookInfo.isPresent());
        assertEquals(inventory+updated, bookInfo.get().getInventory());
    }

    @Test
    public void TestListBook(){
        final BookRepo bookRepo = new BookRepoImpl();
        final String book1 = "Atomic Habits", book2 = "The World For Sale";
        final int inventory1 = 10, inventory2 = 5;
        bookRepo.add(book1, inventory1);
        bookRepo.add(book2, inventory2);

        Optional<BookInfo> bookInfo1 = bookRepo.find(book1);
        Optional<BookInfo> bookInfo2 = bookRepo.find(book2);

        assertTrue(bookInfo1.isPresent());
        assertEquals(inventory1, bookInfo1.get().getInventory());

        assertTrue(bookInfo2.isPresent());
        assertEquals(inventory2, bookInfo2.get().getInventory());
    }

    @Test
    public void TestBorrowBook_WhenStoreEnough(){
        final BookRepo bookRepo = new BookRepoImpl();
        final String book = "Atomic Habits", user = "Wang";
        final int inventory = 10;
        bookRepo.add(book, inventory);

        boolean borrowed = bookRepo.borrow(user, book);
        assertTrue(borrowed);

        Optional<BookInfo> bookInfo = bookRepo.find(book);
        assertTrue(bookInfo.isPresent());
        assertEquals(inventory-1, bookInfo.get().getInventory());
        assertTrue(bookInfo.get().getBorrowedByWho().contains(user));
    }

    @Test
    public void TestBorrowBook_WhenStoreNotEnough(){
        final BookRepo bookRepo = new BookRepoImpl();
        final String book = "Atomic Habits", user = "Wang", user2 = "Li";
        final int inventory = 1;
        bookRepo.add(book, inventory);

        boolean succeed = bookRepo.borrow(user, book);
        assertTrue(succeed);

        Optional<BookInfo> bookInfo = bookRepo.find(book);
        assertTrue(bookInfo.isPresent());
        assertEquals(inventory-1, bookInfo.get().getInventory());
        assertTrue(bookInfo.get().getBorrowedByWho().contains(user));

        boolean failed = bookRepo.borrow(user, book);
        assertTrue(!failed);
    }

    @Test
    public void BookIsDeleted_WhenNoOneBorrowed(){
        final BookRepo bookRepo = new BookRepoImpl();
        final String book = "Atomic Habits";
        final int inventory = 10;
        bookRepo.add(book, inventory);
        bookRepo.delete(book);
        Optional<BookInfo> bookInfo = bookRepo.find(book);
        assertTrue(bookInfo.isEmpty());
    }

    @Test
    public void BookIsNotDeleted_WhenIsBorrowed(){
        final BookRepo bookRepo = new BookRepoImpl();
        final String book = "Atomic Habits", user = "Wang";
        final int inventory = 10;
        bookRepo.add(book, inventory);
        bookRepo.borrow(user, book);

        boolean failed = bookRepo.delete(book);
        assertTrue(!failed);
    }

    @Test
    public void TestReturnBook(){
        final BookRepo bookRepo = new BookRepoImpl();
        final String book = "Atomic Habits", user = "Wang", user2 = "Li";
        final int inventory = 10;
        bookRepo.add(book, inventory);

        boolean succeed1 = bookRepo.borrow(user, book);
        assertTrue(succeed1);

        boolean succeed2 = bookRepo.borrow(user2, book);
        assertTrue(succeed2);

        Optional<BookInfo> bookInfo = bookRepo.find(book);
        assertTrue(bookInfo.isPresent());
        assertEquals(inventory-2, bookInfo.get().getInventory());
        assertTrue(bookInfo.get().getBorrowedByWho().contains(user));
        assertTrue(bookInfo.get().getBorrowedByWho().contains(user2));

        bookRepo.returnBook(user, book);
        Optional<BookInfo> newInfo = bookRepo.find(book);
        assertTrue(newInfo.isPresent());
        assertEquals(inventory-1, newInfo.get().getInventory());
        assertTrue(!newInfo.get().getBorrowedByWho().contains(user));
        assertTrue(newInfo.get().getBorrowedByWho().contains(user2));
    }
}
