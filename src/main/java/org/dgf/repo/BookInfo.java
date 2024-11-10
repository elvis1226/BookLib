package org.dgf.repo;

import java.util.HashSet;
import java.util.Set;

public class BookInfo {

    private final int inventory;
    private final String author;
    private Set<String> borrowedByWho;

    public BookInfo(int inventory, String author) {
        this(inventory, author, new HashSet<>());
    }

    public BookInfo(int inventory, String author, Set<String> borrowed) {
        this.inventory = inventory;
        this.author = author;
        this.borrowedByWho = borrowed;
    }

    public boolean isBorrowed() {
        return this.borrowedByWho.size() > 0;
    }

    public int getInventory() {
        return this.inventory;
    }

    public String getAuthor() {
        return author;
    }

    public Set<String> getBorrowedByWho() {
        return Set.copyOf(this.borrowedByWho);
    }

    public void addBorrowed(String user) {
        this.borrowedByWho.add(user);
    }

    public void clear() {
        this.borrowedByWho.clear();
    }

    @Override
    public String toString() {
        return " - " + author + " - Inventory : " + inventory;
    }
}
