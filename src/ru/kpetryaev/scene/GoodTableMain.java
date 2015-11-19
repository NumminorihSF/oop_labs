package ru.kpetryaev.scene;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GoodTableMain extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        GoodTable table = new GoodTable();
        stage.setScene(new Scene(table));
        stage.setTitle("Custom Control");
        stage.setWidth(300);
        stage.setHeight(200);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
