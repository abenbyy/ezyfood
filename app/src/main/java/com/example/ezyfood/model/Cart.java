package com.example.ezyfood.model;

import java.util.ArrayList;

public class Cart {

    public ArrayList<Item> items;
    public ArrayList<Integer> amounts;
    public static Cart instance;

    public static Cart getInstance(){
        if(instance == null){
            instance = new Cart();
        }
        return instance;
    }

    private Cart(){
        items = new ArrayList<>();
        amounts = new ArrayList<>();
    }
}
