package ru.kpetryaev.lab.lab7.task3;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import ru.kpetryaev.scene.DoubleField;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class Presenter extends javafx.scene.layout.GridPane implements Observer, EventHandler<ActionEvent> {
    @FXML
    DoubleField fieldA;
    @FXML
    DoubleField fieldB;
    @FXML
    DoubleField result;

    @FXML
    ToggleGroup radioButtonGroup;

    @FXML
    Button exit;

    Calc calc = new Calc();

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

    public Presenter(final Stage stage){
        init();
        addObservers();
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.close();
            }
        });
    }

    public void update(Observable obs, Object obj){
        update();
    }

    private void update(){
        if (isUpdating){
            return;
        }
        isUpdating = true;
        for (int i = 0; i < radioButtonGroup.getToggles().size(); i++) {
            if (radioButtonGroup.getToggles().get(i).isSelected()){
                result.setValue(
                        calc.calc(i, fieldA.getValue(), fieldB.getValue())
                );
            }
        }
        isUpdating = false;
    }

    private void addObservers(){
        fieldA.addObserver(this);
        fieldB.addObserver(this);
    }

    @Override
    public void handle(ActionEvent e){
        update();
    }


}
