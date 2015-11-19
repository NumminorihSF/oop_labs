package ru.kpetryaev.scene;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class BallSpace extends Pane implements Observer{
    private BallSpaceModel model = new BallSpaceModel(1);

    public void update(Observable obs, Object obj){
        model.setSizes(this.getWidth(), this.getHeight());
        for (int i = 0; i < this.getChildren().size(); i++) {
                this.getChildren().get(i).setTranslateX(model.getMoveX(i));
                this.getChildren().get(i).setTranslateY(model.getMoveY(i));
        }

    }

    private void init(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "BallSpaceView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        for (int i = this.getChildren().size(); i  < model.size(); i++){
            Circle circle = new Circle(
                    model.getX(i),
                    model.getY(i),
                    model.getRad(i),
                    i%2 == 0 ? Color.BLUE : Color.RED
            );
            this.getChildren().add(i, circle);
        }
    }


    public BallSpace() {
        super();
        model.addBall(100,200, 3);
        init();
        model.addObserver(this);
    }

    public void addObserver(Observer o){
        model.addObserver(o);
    }

    public void removeObserver(Observer o){
        model.deleteObserver(o);
    }

    public void start(){
        this.model.start();
    }
    public void stop(){
        this.model.stop();
    }
    public void setSpeed(int i){
        this.model.setSpeed(i);
    }
}
