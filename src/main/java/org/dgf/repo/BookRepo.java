package org.dgf.repo;

import java.util.HashMap;
import java.util.Map;

public class BookRepo {
    private Map<String, BookStatus> books;

    public BookRepo() {
        this.books = new HashMap<>();
    }

    public static BookRepo creatBookRepo(){
        return new BookRepo();
    }
}
