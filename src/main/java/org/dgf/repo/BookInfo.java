package org.dgf.repo;

import java.util.HashSet;
import java.util.Set;

public class BookInfo {

    private final int inventory;
    private Set<String> borrowedByWho;

    public BookInfo(int inventory) {
        this.inventory = inventory;
        this.borrowedByWho = new HashSet<>();
    }
    public BookInfo(int inventory, Set<String> borrowed) {
        this.inventory = inventory;
        this.borrowedByWho = borrowed;
    }

    public boolean isBorrowed() {
        return this.borrowedByWho.size() > 0;
    }

    public int getInventory() {
        return this.inventory;
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
}
