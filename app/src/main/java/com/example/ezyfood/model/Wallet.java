package com.example.ezyfood.model;

public class Wallet {

    public int amount;
    private static Wallet instance;


    public static Wallet getInstance(){
        if(instance == null){
            instance = new Wallet();
        }

        return instance;
    }

    private Wallet(){
        this.amount = 100000;
    }

}
