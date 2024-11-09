package org.dgf.repo;

import org.dgf.util.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class BookRepoImpl implements BookRepo{
    private Map<String, BookInfo> books;

    public BookRepoImpl() {
        this.books = new HashMap<>();
    }

    @Override
    public void add(String book, int inventory) {
        if (this.books.containsKey(book)){
            BookInfo oldInfo = this.books.get(book);
            BookInfo newInfo = new BookInfo(inventory+oldInfo.getInventory(), oldInfo.getBorrowedByWho());
            this.books.put(book, newInfo);
        }
        else {
            this.books.put(book, new BookInfo(inventory));
        }
    }


    @Override
    public boolean borrow(String user, String book) {
        if (!this.books.containsKey(book)) {
            Logger.warn("The book " + book + " doest exit");
            return false;
        }

        BookInfo oldInfo = this.books.get(book);;

        if (oldInfo.getInventory() <= 0) {
            Logger.warn("All book "  + book + " have been lent out");
            return false;
        }

        Set<String> borrowed = new HashSet<>();
        borrowed.addAll(oldInfo.getBorrowedByWho());
        borrowed.add(user);

        BookInfo newInfo = new BookInfo(oldInfo.getInventory() - 1, borrowed);
        this.books.put(book, newInfo);

        return true;
    }

    @Override
    public boolean delete(String book) {

        if(!this.books.containsKey(book)) {
            return true;
        }
        BookInfo info = this.books.get(book);
        if (info.isBorrowed()) {
            Logger.warn("Cannot delete book " + book + " because it is currently borrowed");
            return false;
        }

        this.books.remove(book);

        return true;
    }

    @Override
    public Set<String> list() {
        return this.books.keySet();
    }

    @Override
    public Optional<BookInfo> find(String book) {
        if(!this.books.containsKey(book)) {
            return Optional.empty();
        }
        return Optional.of(this.books.get(book));
    }

    @Override
    public void returnBook(String user, String book) {
        if (!this.books.containsKey(book)) {
            Logger.warn("The book " + book + " doesnt exist");
            return;
        }
        BookInfo oldInfo = this.books.get(book);
        Set<String> borrowed = oldInfo.getBorrowedByWho()
                                      .stream()
                                      .filter(x-> !x.equals(user))
                                      .collect(Collectors.toSet());
        BookInfo newInfo = new BookInfo(oldInfo.getInventory() + 1, borrowed);
        this.books.put(book, newInfo);
    }
}
