package ru.kpetryaev.scene;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class IntegerField extends javafx.scene.layout.GridPane implements Observer{
    private int lastPos = 1;
    private IntegerFieldModel model = new IntegerFieldModel();

    @FXML
    private TextField field;

    @FXML
    private void increase(ActionEvent e){
        model.setValue(model.getValue() + 1);
    }
    @FXML
    private void decrease(ActionEvent e){
        model.setValue(model.getValue() - 1);
    }
    @FXML
    private void onInputChange(KeyEvent e){
        lastPos = field.getCaretPosition();
        model.setValue(field.getText());
    }

    public void update(Observable obs, Object obj){
        field.setText(Integer.toString(model.getValue()));
        field.positionCaret(lastPos);
    }

    private void init(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "IntegerFieldView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public IntegerField() {
        init();
        model.setMaxValue(null);
        model.setMinValue(null);
        model.addObserver(this);
        model.setValue(0);
    }

    public IntegerField(int value){
        init();
        model.setMaxValue(null);
        model.setMinValue(null);
        model.addObserver(this);
        model.setValue(value);
    }

    public IntegerField(int maxValue, int minValue){
        init();
        model.setMaxValue(maxValue);
        model.setMinValue(minValue);
        model.addObserver(this);
        model.setValue(0);
    }

    public IntegerField(int value, int maxValue, int minValue){
        init();
        model.setMaxValue(maxValue);
        model.setMinValue(minValue);
        model.addObserver(this);
        model.setValue(value);
    }

    public void addObserver(Observer o){
        model.addObserver(o);
    }

    public void removeObserver(Observer o){
        model.deleteObserver(o);
    }

    public int getValue(){
        return model.getValue();
    }

    public void setValue(int v){
        model.setValue(v);
    }

    public void setMin(int min){
        model.setMinValue(min);
    }
    public void setMax(int max){
        model.setMaxValue(max);
    }
}
