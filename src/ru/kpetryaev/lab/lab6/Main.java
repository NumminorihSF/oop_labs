package ru.kpetryaev.lab.lab6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        Presenter lab = new Presenter();
        stage.setScene(new Scene(lab));
        stage.setTitle("Lab");
        stage.setWidth(650);
        stage.setHeight(550);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
