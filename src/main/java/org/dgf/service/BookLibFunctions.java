package org.dgf.service;

public interface BookLibFunctions {
    void listBooks();
    boolean searchBook(String bookName);
    void addBook(String bookName, int inventory);
    boolean borrowBook(String bookName);
    void returnBook(String bookName);
    boolean deleteBook(String bookName);
}