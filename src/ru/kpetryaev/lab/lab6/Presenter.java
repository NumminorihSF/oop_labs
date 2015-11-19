package ru.kpetryaev.lab.lab6;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import ru.kpetryaev.scene.BallSpace;
import ru.kpetryaev.scene.IntegerField;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class Presenter extends javafx.scene.layout.GridPane implements Observer, EventHandler<MouseEvent> {
    @FXML
    IntegerField speed;
    @FXML
    BallSpace space;
    @FXML
    Button start;
    @FXML
    Button stop;


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

    private boolean isUpdating = false;

    public void update(Observable obs, Object obj){
        if (isUpdating) {
            return;
        }
        isUpdating = true;
        space.setSpeed(speed.getValue());
        isUpdating = false;
    }



    public Presenter(){
        init();
        addObservers();
        speed.setMax(100);
        speed.setMin(1);
        speed.setValue(1);
        start.setOnMouseClicked(this);
        stop.setOnMouseClicked(this);
    }

    public void handle(MouseEvent e){
        if (((Button) e.getSource()).getText().equalsIgnoreCase("пуск")){
            this.space.start();
        }
        else {
            this.space.stop();
        }
    }

    private void addObservers(){
       // space.addObserver(this);
        speed.addObserver(this);
    }


}
