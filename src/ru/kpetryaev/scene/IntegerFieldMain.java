package ru.kpetryaev.scene;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class IntegerFieldMain extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        IntegerField integerField = new IntegerField();
        stage.setScene(new Scene(integerField));
        stage.setTitle("Custom Control");
        stage.setWidth(300);
        stage.setHeight(200);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
