package ru.kpetryaev.lab.lab8;

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
        stage.setHeight(500);
        stage.setMinHeight(500);
        stage.setMaxHeight(500);
        stage.setMinWidth(800);
        stage.setMaxWidth(800);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
