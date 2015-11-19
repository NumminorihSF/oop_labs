package ru.kpetryaev.scene;

import java.util.Observable;

class DoubleFieldModel extends Observable{
    double value = 0;
    Double maxValue = null;
    Double minValue = null;

    public void setValue (String s){
        double val;
        try {
            val = Double.parseDouble(s.trim());
        }
        catch(Exception e){
            val = value;
        }
        setValue(val);
    }

    public void setValue(double val){
        value = limitMax(limitMin(val));
        this.setChanged();
        this.notifyObservers();
    }

    private double limitMax(double val){
        if (maxValue != null && maxValue < val){
            return maxValue;
        }
        return val;
    }

    private double limitMin(double val){
        if (minValue != null && minValue > val){
            return minValue;
        }
        return val;
    }

    public double getValue(){
        return value;
    }

    public void setMaxValue(Double value){
        maxValue = value;
    }

    public void setMinValue(Double value){
        minValue = value;
    }
}
