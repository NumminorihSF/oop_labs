package ru.kpetryaev.lab.lab7.task4;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
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
    TextArea result;

    @FXML
    VBox checkBoxGroup;

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
        String allResults = "";
        for (int i = 0; i < checkBoxGroup.getChildren().size(); i++) {
                if (((CheckBox) (checkBoxGroup.getChildren().get(i))).isSelected()){
                    allResults += ((i == 0) ? "X" : ((i == 1) ? "Y" : "Z")) +
                            " = " + calc.calc(i, fieldA.getValue(), fieldB.getValue()) + "\n";
                }
        }
        result.setText(allResults);
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
