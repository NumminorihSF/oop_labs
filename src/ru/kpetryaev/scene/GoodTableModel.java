package ru.kpetryaev.scene;

import java.util.ArrayList;
import java.util.Observable;

class   GoodTableModel extends Observable{

    private ArrayList<ModelColumn> columns = new ArrayList<ModelColumn>(0);

    public GoodTableModel(){}

    public int getGoodsCapacity(){
        return columns.size();
    }
    public void setGoodsCapacity(int capacity){
        if (capacity < 0 || capacity == columns.size()) {
            return;
        }
        while (columns.size() < capacity){
            columns.add(columns.size(), new ModelColumn());
        }
        while (columns.size() > capacity){
            columns.remove(columns.size() - 1);
        }
        this.setChanged();
        this.notifyObservers();
    }
    public void setGoodName(int index, String name){
        columns.get(index).setName(name);
        this.setChanged();
        this.notifyObservers();
    }
    public String getGoodName(int index){
        return  columns.get(index).getName();
    }
    public void setGoodPrice(int index, String price){
        int val;
        try {
            val = Integer.parseInt(price.trim());
        }
        catch(Exception e){
            this.setChanged();
            this.notifyObservers();
            return;
        }
        setGoodPrice(index, val);
    }
    public void setGoodPrice(int index, int price){
        columns.get(index).setPrice(price);
        this.setChanged();
        this.notifyObservers();
    }
    public int getGoodPrice(int index){
        return  columns.get(index).getPrice();
    }
    public void setGoodCount(int index, String count){
        int val;
        try {
            val = Integer.parseInt(count.trim());
        }
        catch(Exception e){
            this.setChanged();
            this.notifyObservers();
            return;
        }
        setGoodCount(index, val);
    }
    public void setGoodCount(int index, int count){
        columns.get(index).setCount(count);
        this.setChanged();
        this.notifyObservers();
    }
    public int getGoodCount(int index){
        return  columns.get(index).getCount();
    }
    public int getGoodCost(int index){
        return columns.get(index).getCost();
    }

    private class ModelColumn {
        private String name = "";
        private int price;
        private int count;
        ModelColumn (){}
        void setName(String name){
            this.name = name;
        }
        String getName(){
            return name;
        }
        void setPrice(int price){
            this.price = price;
        }
        int getPrice(){
            return price;
        }
        void setCount(int count){
            this.count = count;
        }
        int getCount(){
            return count;
        }
        int getCost(){
            return price * count;
        }
    }
}

