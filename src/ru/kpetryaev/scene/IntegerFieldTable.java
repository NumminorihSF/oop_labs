package ru.kpetryaev.scene;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class IntegerFieldTable extends javafx.scene.layout.GridPane implements Observer{
    private IntegerFieldTableModel model = new IntegerFieldTableModel();

    public void update(Observable obs, Object obj){
        int height = model.getSize()[0];
        int width = model.getSize()[1];

        fixSize(height, width);

        for(int i = 0; i <= height; i++){
            for (int j = 0; j <= width; j++){
                if (!isDrawed(i, j)) {
                    drawChildren(i, j);
                }
                else if (i > 0 && j > 0) {
                    changeValue(i, j, model.getElement(i, j));
                }
            }
        }
    }

    private void changeValue(int i, int j, int value){
        ObservableList<Node> children = this.getChildren();
        for (int k = 0; k < children.size(); k++){
            if (getRowIndex(children.get(k)) == i && getColumnIndex(children.get(k)) == j){
                ((TextField) children.get(k)).setText(
                        Integer.toString(model.getElement(i, j))
                );
                return;
            }
        }
    }

    private void fixSize(int h, int w){
        ObservableList<Node> children = this.getChildren();
        for (int i = 0; i < children.size(); ){
            if (getColumnIndex(children.get(i)) > w){ //если за пределами по ширине
                children.remove(i);
            }
            else if (getRowIndex(children.get(i)) > h){ //если за пределами высоты
                children.remove(i);
            }
            else {
                i++;
            }
        }
    }

    private boolean isDrawed(int i, int j){
        ObservableList<Node> children = this.getChildren();
        for (int k = 0; k < children.size(); k++){
            if (getColumnIndex(children.get(k)) == j){ //если совпадает по высоте
                if (getRowIndex(children.get(k)) == i){
                    return true;
                }
            }
        }
        return false;
    }

    private void drawChildren(int i, int j){
        Node node;
        if (i == 0  || j == 0){
            String label;
            if (i != 0) {
                label = Integer.toString(i);
            }
            else if (j != 0){
                label = Integer.toString(j);
            }
            else {
                label = "";
            }
            node = new Button(label);
            node.setDisable(true);
        }
        else {
            node = new TextField(
                    Integer.toString(model.getElement(i, j))
            );
            node.setOnKeyReleased(new IntegerFieldTableEventHandler(i, j, model, (TextField) node));
        }

        //((Control) node).setPrefWidth(this.getWidth()/ model.getSize()[1]);
        ((Control) node).setPrefWidth(30);
        this.add(node, j, i);
    }

    private void init(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "IntegerFieldTableView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public IntegerFieldTable() {
        init();
        model.addObserver(this);
        model.setSize(5, 5);
    }

    public IntegerFieldTable(int height, int width){
        init();
        model.addObserver(this);
        model.setSize(height, width);
    }

    public void addObserver(Observer o){
        model.addObserver(o);
    }

    public void removeObserver(Observer o){
        model.deleteObserver(o);
    }

    public void setSize(int i, int j){
        model.setSize(i, j);
    }

    public int getValue(int i, int j){
        return model.getElement(i, j);
    }

    public void setValue(int i, int j, int v){
        model.setElement(i, j, v);
    }
}
