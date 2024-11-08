package org.dgf.service;

public interface BookLib {
    boolean login(String user, String password);
    boolean register(String user, String password, String type);

    void listBooks();
    boolean searchBook(String bookName);
    void addBook(String bookName, int inventory);
    boolean borrowBook(String bookName);
    void returnBook(String bookName);
    boolean deleteBook(String bookName);

    static BookLib createBookLib() {
        return new DefaultBookLibImp();
    }
}
