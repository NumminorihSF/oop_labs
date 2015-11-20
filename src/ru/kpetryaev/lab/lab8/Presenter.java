package ru.kpetryaev.lab.lab8;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Region;
import javafx.scene.shape.Shape;


import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class Presenter extends javafx.scene.layout.AnchorPane implements Observer {
    @FXML
    ToggleGroup radioButtonGroup;
    @FXML
    ColorPicker lineColor;
    @FXML
    ColorPicker backColor;
    @FXML
    ColorPicker fillColor;
    @FXML
    Canvas tempCanvas;
    @FXML
    Canvas canvas;
    @FXML
    AnchorPane underCanvas;

    GraphicsContext context;
    GraphicsContext tempContext;

    private double startX;
    private double startY;

    private Shape tempShape;

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

    

    @FXML
    private void changeBackColor(ActionEvent e){
        String col = backColor.getValue().toString().replaceAll("0x", "").replaceAll("ff$", "");
        underCanvas.setStyle("-fx-background-color: #" + col + ";");
    }

    @FXML
    private void onCanvasMousePress(MouseEvent e){
        System.out.println("Press\tX = " + e.getX() + "\tY = "+e.getY());
        startX = e.getX();
        startY = e.getY();
    }

    @FXML
    private void onCanvasMouseDrag(MouseEvent e){
        System.out.println(e);
        drawShape(tempContext, startX, startY, e.getX(), e.getY());
    }

    @FXML
    private void onCanvasMouseRelease(MouseEvent e){
        System.out.println("Release\tX = " + e.getX() + "\tY = "+e.getY());
        drawShape(context, startX, startY, e.getX(), e.getY());
    }

    private void drawShape(GraphicsContext context, double startX, double startY, double endX, double endY){
        String selected = ((RadioButton) radioButtonGroup.getSelectedToggle()).getText();
        context.setFill(fillColor.getValue());
        context.setStroke(lineColor.getValue());
        context.setLineWidth(1);
        tempContext.clearRect(0,0,tempCanvas.getWidth(), tempCanvas.getHeight());
        if (selected.equals("Отрезок")){
            drawLine(context, startX, startY, endX, endY);
        }
        else if (selected.equals("Элипс")){
            drawElips(context, Math.min(startX, endX), Math.min(startY, endY), Math.abs(startX-endX), Math.abs(startY-endY));
        }
        else if (selected.equals("Прямоугольник")){
            drawRect(context, Math.min(startX, endX), Math.min(startY, endY), Math.abs(startX-endX), Math.abs(startY-endY));
        }
    }


    private void drawLine(GraphicsContext context, double startX, double startY, double endX, double endY){
        context.strokeLine(startX, startY, endX, endY);
    }

    private void drawElips(GraphicsContext context, double startX, double startY, double endX, double endY){
        context.fillOval(startX, startY, endX, endY);
        context.strokeOval(startX, startY, endX, endY);
    }

    private void drawRect(GraphicsContext context, double startX, double startY, double endX, double endY){
        context.fillRect(startX, startY, endX, endY);
        context.strokeRect(startX, startY, endX, endY);
    }

    public Presenter(){
        init();
        context = canvas.getGraphicsContext2D();
        tempContext = tempCanvas.getGraphicsContext2D();
    }



}
