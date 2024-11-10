package org.dgf.repo;

import java.util.Optional;

public interface BookRepo {
    void add(String book, int inventory, String author);

    boolean borrow(String user, String book);

    boolean delete(String book);

    void list();

    Optional<BookInfo> find(String book);

    void returnBook(String user, String book);
}
