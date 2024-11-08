package org.dgf.repo;

public class BookStatus {

    private final int inventory;
    private final boolean borrowed;

    public BookStatus(int inventory, boolean borrowed) {
        this.inventory = inventory;
        this.borrowed = borrowed;
    }

    public boolean isBorrowed() {
        return this.borrowed;
    }

    public int getInventory() {
        return inventory;
    }
}
