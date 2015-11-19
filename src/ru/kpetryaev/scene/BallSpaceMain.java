package ru.kpetryaev.scene;

import javafx.application.Application;
import javafx.stage.Stage;

public class BallSpaceMain extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        BallSpace ballSpace = new BallSpace();
       // stage.setScene(new Scene(ballSpace));
        stage.setTitle("Custom Control");
        stage.setWidth(500);
        stage.setHeight(400);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
