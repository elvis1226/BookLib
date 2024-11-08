package org.dgf.repo;

import org.dgf.model.Book;

import java.util.HashMap;
import java.util.Map;

public class BookRepo {
    private Map<Book, Integer> books;

    public BookRepo() {
        this.books = new HashMap<>();
    }
}
