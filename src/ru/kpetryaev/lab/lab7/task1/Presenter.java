package ru.kpetryaev.lab.lab7.task1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import ru.kpetryaev.scene.IntegerField;

import java.io.IOException;


public class Presenter extends javafx.scene.layout.GridPane implements EventHandler<ActionEvent> {
    @FXML
    IntegerField cathetus1;
    @FXML
    IntegerField cathetus2;
    @FXML
    TextArea result;
    @FXML
    Button calc;
    @FXML
    Button exit;

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
        cathetus1.setMin(0);
        cathetus2.setMin(0);
        calc.setOnAction(this);
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.close();
            }
        });
    }

    public void handle(ActionEvent e){
        result.setText(
                formAnswer(
                        cathetus1.getValue(),
                        cathetus2.getValue(),
                        new Triangle(
                                cathetus1.getValue(),
                                cathetus2.getValue()
                        ).getHypotenuse()
                )
        );
    }

    private String formAnswer(int c1, int c2, double h){
        return "Катет 1 - " + c1 + "\nКатет 2 - " + c2 + "\nГипотенуза - " + Math.floor(h*100)/100;
    }


}
