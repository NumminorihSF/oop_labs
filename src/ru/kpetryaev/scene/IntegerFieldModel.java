package ru.kpetryaev.scene;

import java.util.Observable;

class IntegerFieldModel extends Observable{
    int value = 0;
    Integer maxValue = null;
    Integer minValue = null;

    public void setValue (String s){
        int val;
        try {
            val = Integer.parseInt(s.trim());
        }
        catch(Exception e){
            val = value;
        }
        setValue(val);
    }

    public void setValue(int val){
        value = limitMax(limitMin(val));
        this.setChanged();
        this.notifyObservers();
    }

    private int limitMax(int val){
        if (maxValue != null && maxValue < val){
            return maxValue;
        }
        return val;
    }

    private int limitMin(int val){
        if (minValue != null && minValue > val){
            return minValue;
        }
        return val;
    }

    public int getValue(){
        return value;
    }

    public void setMaxValue(Integer value){
        maxValue = value;
    }

    public void setMinValue(Integer value){
        minValue = value;
    }
}
