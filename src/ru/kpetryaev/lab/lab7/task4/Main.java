package ru.kpetryaev.lab.lab7.task4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        Presenter lab = new Presenter(stage);
        stage.setScene(new Scene(lab));
        stage.setTitle("Task 4");
        stage.setWidth(660);
        stage.setHeight(300);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
