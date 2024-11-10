package org.dgf.repo;

import org.dgf.util.Logger;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BookRepoImpl implements BookRepo{
    private Map<String, BookInfo> books;

    public BookRepoImpl() {
        this.books = new HashMap<>();
    }

    @Override
    public void add(String book, int inventory, String author) {
        if (this.books.containsKey(book)){
            BookInfo oldInfo = this.books.get(book);
            BookInfo newInfo = new BookInfo(inventory+oldInfo.getInventory(), author, oldInfo.getBorrowedByWho());
            this.books.put(book, newInfo);
            Logger.info("Book \"" + book + "\" inventory successfully updated, new inventory: " + inventory );
        }
        else {
            this.books.put(book, new BookInfo(inventory, author));
            Logger.info("Book \"" + book + "\" by " + author + " added successfully, inventory: " + inventory + ".");
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

        BookInfo newInfo = new BookInfo(oldInfo.getInventory() - 1, oldInfo.getAuthor(), borrowed);
        this.books.put(book, newInfo);
        Logger.info("Book \"" + book + "\" successfully borrowed");
        return true;
    }

    @Override
    public boolean delete(String book) {

        if(!this.books.containsKey(book)) {
            return true;
        }
        BookInfo info = this.books.get(book);
        if (info.isBorrowed()) {
            Logger.info("Cannot delete book \"" + book + "\" because it is currently borrowed");
            return false;
        }

        this.books.remove(book);
        Logger.info("Book \"" + book + "\" is deleted");
        return true;
    }

    @Override
    public void list() {
        final Iterator<Integer> index = IntStream.range(1, books.size()+1).iterator();
        books.entrySet().forEach(
                e -> Logger.info(index.next() + ". " + e.getKey() + e.getValue().toString())
        );
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
        BookInfo newInfo = new BookInfo(oldInfo.getInventory() + 1, oldInfo.getAuthor(), borrowed);
        this.books.put(book, newInfo);
    }
}
