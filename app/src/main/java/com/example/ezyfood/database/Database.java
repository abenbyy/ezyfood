package com.example.ezyfood.database;

import com.example.ezyfood.model.Item;

import java.util.ArrayList;

public class Database {

    public static ArrayList<Item> items;
    public static Database instance;

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
