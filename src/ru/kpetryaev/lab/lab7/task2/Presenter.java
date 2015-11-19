package ru.kpetryaev.lab.lab7.task2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import ru.kpetryaev.scene.IntegerField;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class Presenter extends javafx.scene.layout.GridPane implements Observer {
    @FXML
    IntegerField startSpeed;
    @FXML
    IntegerField acceleration;
    @FXML
    IntegerField time;
    @FXML
    IntegerField finishSpeed;
    @FXML
    IntegerField path;

    @FXML
    Button exit;

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
        time.setMin(0);
        addObservers();
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.close();
            }
        });
    }

    public void update(Observable obs, Object obj){
        if (isUpdating){
            return;
        }
        isUpdating = true;
        PhysicBodyMoving moving = new PhysicBodyMoving(
                startSpeed.getValue(),
                acceleration.getValue(),
                time.getValue()
        );
        finishSpeed.setValue(moving.getFinishSpeed());
        path.setValue(moving.getPath());
        isUpdating = false;
    }

    private void addObservers(){
        startSpeed.addObserver(this);
        acceleration.addObserver(this);
        time.addObserver(this);
        finishSpeed.addObserver(this);
        path.addObserver(this);
    }



}
