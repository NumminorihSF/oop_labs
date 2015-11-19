package ru.kpetryaev.scene;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DoubleFieldMain extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        DoubleField field = new DoubleField();
        stage.setScene(new Scene(field));
        stage.setTitle("Custom Control");
        stage.setWidth(300);
        stage.setHeight(200);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
