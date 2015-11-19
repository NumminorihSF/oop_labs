package ru.kpetryaev.lab.lab4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import ru.kpetryaev.scene.IntegerField;
import ru.kpetryaev.scene.IntegerFieldTable;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class Presenter extends javafx.scene.layout.GridPane implements Observer {
    @FXML
    IntegerField heightField;
    @FXML
    IntegerField widthField;
    @FXML
    IntegerFieldTable firstTable;
    @FXML
    IntegerFieldTable secondTable;
    @FXML
    IntegerFieldTable resultTable;
    private boolean isUpdating = false;

    private void init(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "View.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }


    public void update(Observable obs, Object obj){
        if (isUpdating) {
            return;
        }
        isUpdating = true;
        fixTableSize();
        updateTableValues();
        isUpdating = false;
    }

    public Presenter(){
        init();
        setSizes();
        addObservers();
        setFieldMax(10);
        setFieldMin(1);
    }

    private void addObservers(){
        heightField.addObserver(this);
        widthField.addObserver(this);
        firstTable.addObserver(this);
        secondTable.addObserver(this);
        resultTable.addObserver(this);
    }

    private void setFieldMin(int i){
        heightField.setMin(i);
        widthField.setMin(i);
    }
    private void setFieldMax(int i){
        heightField.setMax(i);
        widthField.setMax(i);
    }
    private void setSizes(){
        heightField.setValue(5);
        widthField.setValue(5);
    }

    private void fixTableSize(){
        firstTable.setSize(heightField.getValue(), widthField.getValue());
        secondTable.setSize(heightField.getValue(), widthField.getValue());
        resultTable.setSize(heightField.getValue(), widthField.getValue());
    }

    private void updateTableValues(){
        for(int i = 1; i <= heightField.getValue(); i++){
            for(int j = 1; j <= widthField.getValue(); j++){
                resultTable.setValue(i, j, (
                        firstTable.getValue(i, j) + secondTable.getValue(i, j)
                        ));
            }
        }
    }
}
