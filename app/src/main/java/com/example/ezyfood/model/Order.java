package com.example.ezyfood.model;

public class Order {
    private Item item;
    private int amount;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Order(Item item, int amount) {
        this.item = item;
        this.amount = amount;
    }
}
