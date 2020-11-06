package com.example.ezyfood.model;

public class Item {
    private String name;
    private String type;
    private int price;
    private int image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Item(String name, String type, int price, int image) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.image = image;
    }
}
