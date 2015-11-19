package ru.kpetryaev.lab.lab7;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class Presenter extends javafx.scene.layout.GridPane implements Observer {
    @FXML
    MenuItem task1;
    @FXML
    MenuItem task2;
    @FXML
    MenuItem task3;
    @FXML
    MenuItem task4;
    @FXML
    Menu exit;
    @FXML
    private Parent root;

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


    public void update(Observable obs, Object obj){}

    private void setMenuItemActions(){
        final Parent parent =  root;
        task1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = new Stage();
                ru.kpetryaev.lab.lab7.task1.Presenter root = new ru.kpetryaev.lab.lab7.task1.Presenter(stage);

                stage.setScene(new Scene(root));
                stage.setTitle("Task 1");
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner((Stage) parent.getScene().getWindow());
                stage.show();
            }
        });
        task2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = new Stage();
                ru.kpetryaev.lab.lab7.task2.Presenter root = new ru.kpetryaev.lab.lab7.task2.Presenter(stage);

                stage.setScene(new Scene(root));
                stage.setTitle("Task 2");
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner((Stage) parent.getScene().getWindow());
                stage.show();
            }
        });
        task3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = new Stage();
                ru.kpetryaev.lab.lab7.task3.Presenter root = new ru.kpetryaev.lab.lab7.task3.Presenter(stage);

                stage.setScene(new Scene(root));
                stage.setTitle("Task 3");
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner((Stage) parent.getScene().getWindow());
                stage.show();
            }
        });
        task4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = new Stage();
                ru.kpetryaev.lab.lab7.task4.Presenter root = new ru.kpetryaev.lab.lab7.task4.Presenter(stage);

                stage.setScene(new Scene(root));
                stage.setTitle("Task 4");
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner((Stage) parent.getScene().getWindow());
                stage.show();
            }
        });

        exit.setOnShowing(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                System.exit(0);
            }
        });

    }

    private void setMenuItemShortCuts(){
        task1.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN));
        task2.setAccelerator(new KeyCodeCombination(KeyCode.B, KeyCombination.CONTROL_DOWN));
        task3.setAccelerator(new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN));
        task4.setAccelerator(new KeyCodeCombination(KeyCode.D, KeyCombination.CONTROL_DOWN));
    }

    public Presenter(){
        init();
        setMenuItemActions();
        setMenuItemShortCuts();
    }



}
