package ru.kpetryaev.lab.lab5;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.chart.PieChart;
import ru.kpetryaev.scene.GoodTable;
import ru.kpetryaev.scene.IntegerField;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class Presenter extends javafx.scene.layout.GridPane implements Observer {
    @FXML
    IntegerField capacity;
    @FXML
    GoodTable table;
    @FXML
    PieChart chart;

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

    private boolean isUpdating = false;

    public void update(Observable obs, Object obj){
        if (isUpdating) {
            return;
        }
        isUpdating = true;
        table.setCapacity(capacity.getValue());
        updateChartValues();
        isUpdating = false;
    }

    public Presenter(){
        init();
        addObservers();
        setCapacity(3);
        setFieldMax(10);
        setFieldMin(1);
    }

    private void addObservers(){
        capacity.addObserver(this);
        table.addObserver(this);
    }

    private void setFieldMin(int i){
        capacity.setMin(i);
    }
    private void setFieldMax(int i){
        capacity.setMax(i);
    }
    private void setCapacity(int i){
        capacity.setValue(i);
    }
    private void updateChartValues(){
        int summ = 0;
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList();
        for (int i = 0; i < capacity.getValue(); i++){
            summ += table.getGoodCost(i);
        }
        if (summ == 0){
            summ = 1;
        }
        for (int i = 0; i < capacity.getValue(); i++){
            pieChartData.add(
                    new PieChart.Data(
                            table.getGoodCost(i)+" ("+
                                    Math.floor(table.getGoodCost(i)*10000/summ)/100+"%) "+
                                    table.getGoodName(i), table.getGoodCost(i)
                    )
            );
        }

        this.chart.setData(pieChartData);

    }
}
