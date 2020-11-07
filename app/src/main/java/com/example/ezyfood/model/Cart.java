package com.example.ezyfood.model;

import java.util.ArrayList;

public class Cart {

    public ArrayList<Order> orders;
    public int grandTotal;
    public static Cart instance;

    public void removeItem(String query){
        int idx = 0;
        for(int i=0;i<orders.size();i++){
            if(orders.get(i).getItem().getName().equals(query)){
                idx = i;
                break;
            }
        }

        orders.remove(idx);
    }

    public void addItem(Item item, int amount){
        boolean found = false;
        for(int i=0;i<orders.size();i++){
            if(orders.get(i).getItem().getName().equals(item.getName())){
                found = true;
                orders.get(i).setAmount(orders.get(i).getAmount() + amount);
            }
        }
        if(!found) orders.add(new Order(item, amount));;
        grandTotal += item.getPrice() * amount;
    }
    public static Cart getInstance(){
        if(instance == null){
            instance = new Cart();
        }
        return instance;
    }

    private Cart(){
        orders = new ArrayList<>();
        grandTotal = 0;
    }
}
