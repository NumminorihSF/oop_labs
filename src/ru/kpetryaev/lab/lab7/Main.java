package ru.kpetryaev.lab.lab7;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        Presenter lab = new Presenter();
        stage.setScene(new Scene(lab));
        stage.setTitle("Lab");
        stage.setWidth(800);
        stage.setHeight(700);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
