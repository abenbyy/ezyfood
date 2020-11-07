package com.example.ezyfood.database;

import com.example.ezyfood.model.Item;

import java.util.ArrayList;

public class Database {

    public static ArrayList<Item> items;
    public static Database instance;

    public ArrayList<Item> getItems(String query){
        ArrayList<Item> result = new ArrayList<>();

        for (Item i: items) {
            if(i.getType().equals(query)) result.add(i);
        }

        return result;
    }

    public Item getItem(String query){
        for (Item i: items) {
            if(i.getName().equals(query)) return i;
        }

        return null;
    }

    public static Database getInstance(){
        if(instance == null){
            instance = new Database();
        }
        return instance;
    }

    private Database() {
        items = new ArrayList<>();
    }
}
