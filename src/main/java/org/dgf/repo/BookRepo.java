package org.dgf.repo;

import java.util.Optional;

public interface BookRepo {
    void add(String name, int inventory, String author);

    boolean borrow(String user, String name, String author);

    boolean delete(String name, String author);

    void list();

    Optional<BookInfo> find(String name, String author);

    void search(String name, String author);

    void returnBook(String user, String name, String author);
}
