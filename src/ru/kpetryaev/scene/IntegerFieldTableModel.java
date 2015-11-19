package ru.kpetryaev.scene;

import java.util.ArrayList;
import java.util.Observable;

class IntegerFieldTableModel extends Observable{

    private ArrayList<ModelRow> rows = new ArrayList<ModelRow>(0);

    public IntegerFieldTableModel(){
        this.setSize(5,5);
    }

    public IntegerFieldTableModel(int i, int j){
        this.setSize(i, j);
    }

    public Integer[] getSize(){
        int width = 0;
        ModelRow row = this.rows.get(0);
        if (!row.equals(null)) width = row.getSize();
        return new Integer[]{this.rows.size(), width};
    }

    public IntegerFieldTableModel setSize(int i, int j){
        while (rows.size() > i){
            rows.remove(rows.size() - 1);
        }
        while (rows.size() < i){
            rows.add(new ModelRow(j));
        }
        for (int k = 0; k < rows.size(); k++){
            rows.get(k).setSize(j);
        }
        this.setChanged();
        this.notifyObservers();
        return this;
    }

    public IntegerFieldTableModel setWidth(int j){
        for (int k = 0; k < rows.size(); k++){
            rows.get(k).setSize(j);
        }
        this.setChanged();
        this.notifyObservers();
        return this;
    }

    public IntegerFieldTableModel setHeight(int i){
        int width = rows.get(0).getSize();
        while (rows.size() > i){
            rows.remove(rows.size() - 1);
        }
        while (rows.size() < i){
            rows.add(new ModelRow(width));
        }
        this.setChanged();
        this.notifyObservers();
        return this;
    }

    public int getElement (int i, int j){
        if (i < 0 || i > this.rows.size()) return 0;
        return this.getRow(i - 1).getElement(j - 1);
    }

    public IntegerFieldTableModel setElement (int i, int j, String s){
        int val;
        try {
            val = Integer.parseInt(s.trim());
        } catch(Exception e){
            if (s.length() > 0) {
                val = getElement(i, j);
            }
            else {
                val = 0;
            }
        }
        setElement(i, j, val);
        return this;
    }

    public IntegerFieldTableModel setElement (int i, int j, int value){
        if (i < 0 || i > this.rows.size()) return this;
        ModelRow row = this.getRow(i - 1);
        if (row.equals(null)) return this;
        row.setElement(j - 1, value);
        this.setChanged();
        this.notifyObservers();
        return this;
    }


    private ModelRow getRow(int index){
        return this.rows.get(index);
    }

    private class ModelRow {
        private ArrayList<Integer> elements = new ArrayList<Integer>(0);
        public ModelRow setSize(int j){
            while (elements.size() > j){
                elements.remove(elements.size() - 1);
            }
            while (elements.size() < j){
                elements.add(0);
            }
            return this;
        }
        public ModelRow (int j){
            this.setSize(j);
        }
        public Integer getElement(int j){
            if (j >= this.elements.size()){
                return 0;
            }
            return this.elements.get(j);
        }
        public ModelRow setElement(int j, int value){
            if (j >= elements.size()){
                return this;
            }
            this.elements.set(j, value);
            return this;
        }
        public Integer getSize(){
            return this.elements.size();
        }
    }
}

