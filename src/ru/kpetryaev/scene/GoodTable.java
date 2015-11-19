package ru.kpetryaev.scene;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class GoodTable extends javafx.scene.layout.GridPane implements Observer{
    private GoodTableModel model = new GoodTableModel();

    public void update(Observable obs, Object obj){
        int width = model.getGoodsCapacity();

        fixSize(width);

        for (int j = 0; j <= width; j++){
            if (!isDrawed(j)) {
                drawColumn(j);
            }
            else if (j > 0) {
                changeValue(j);
            }
        }

    }

    private void changeValue(int j){
        ObservableList<Node> children = this.getChildren();

        for (int k = 0; k < children.size(); k++){
            if (getColumnIndex(children.get(k)) == j){
                if (getRowIndex(children.get(k)) == 1)
                    ((TextField) children.get(k)).setText(model.getGoodName(j - 1));
                else if (getRowIndex(children.get(k)) == 2)
                    ((TextField) children.get(k)).setText(
                            Integer.toString(model.getGoodPrice(j - 1))
                    );
                else if (getRowIndex(children.get(k)) == 3)
                    ((TextField) children.get(k)).setText(
                            Integer.toString(model.getGoodCount(j - 1))
                    );
                else if (getRowIndex(children.get(k)) == 4)
                    ((TextField) children.get(k)).setText(
                            Integer.toString(model.getGoodCost(j - 1))
                    );
            }

        }
    }

    private void fixSize(int w){
        ObservableList<Node> children = this.getChildren();
        for (int i = 0; i < children.size(); ){
            if (getColumnIndex(children.get(i)) > w){ //если за пределами по ширине
                children.remove(i);
            }
            else {
                i++;
            }
        }
    }

    private boolean isDrawed(int j){
        ObservableList<Node> children = this.getChildren();
        for (int k = 0; k < children.size(); k++){
            if (getColumnIndex(children.get(k)) == j){
                return true;
            }
        }
        return false;
    }

    private void drawColumn(int j){
        Node node;
        if (j == 0){
            node = new Button("№ п/п");
            node.setDisable(true);
            ((Control) node).setPrefWidth(100);
            this.add(node, 0, 0);

            node = new Button("Товар");
            node.setDisable(true);
            ((Control) node).setPrefWidth(100);
            this.add(node, 0, 1);

            node = new Button("Цена");
            node.setDisable(true);
            ((Control) node).setPrefWidth(100);
            this.add(node, 0, 2);

            node = new Button("Количество");
            node.setDisable(true);
            ((Control) node).setPrefWidth(100);
            this.add(node, 0, 3);

            node = new Button("Стоимость");
            node.setDisable(true);
            ((Control) node).setPrefWidth(100);
            this.add(node, 0, 4);
        }
        else {
            node = new Button(Integer.toString(j));
            node.setDisable(true);
            ((Control) node).setPrefWidth(150);
            this.add(node, j, 0);

            node = new TextField(model.getGoodName(j-1));
            node.setOnKeyReleased(new GoodTableNameEventHandler(j-1, model, (TextField) node));
            ((Control) node).setPrefWidth(150);
            this.add(node, j, 1);

            node = new TextField(Integer.toString(model.getGoodPrice(j-1)));
            node.setOnKeyReleased(new GoodTablePriceEventHandler(j-1, model, (TextField) node));
            ((Control) node).setPrefWidth(150);
            this.add(node, j, 2);

            node = new TextField(Integer.toString(model.getGoodCount(j-1)));
            node.setOnKeyReleased(new GoodTableCountEventHandler(j-1, model, (TextField) node));
            ((Control) node).setPrefWidth(150);
            this.add(node, j, 3);

            node = new TextField(Integer.toString(model.getGoodCost(j - 1)));
            node.setOnKeyReleased(new GoodTableCostEventHandler(j-1, model, (TextField) node));
            ((Control) node).setPrefWidth(100);
            this.add(node, j, 4);
        }
    }

    private void init(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "GoodTableView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public GoodTable() {
        init();
        model.addObserver(this);
        model.setGoodsCapacity(3);
    }

    public GoodTable(int capacity){
        init();
        model.addObserver(this);
        model.setGoodsCapacity(capacity);
    }

    public void setCapacity(int capacity){
        model.setGoodsCapacity(capacity);
    }

    public void addObserver(Observer o){
        model.addObserver(o);
    }

    public void removeObserver(Observer o){
        model.deleteObserver(o);
    }

    public String getGoodName(int index){
        return model.getGoodName(index);
    }
    public int getGoodCost(int index){
        return model.getGoodCost(index);
    }
}
