package org.dgf.repo;


import java.util.Optional;
import java.util.Set;

public interface BookRepo {
    void add(String book, int inventory);

    boolean borrow(String user, String book);

    boolean delete(String book);

    Set<String> list();

    Optional<BookInfo> find(String book);

    void returnBook(String user, String book);
}
