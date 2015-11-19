package ru.kpetryaev.scene;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;


/**
 * Created by NumminorihSF on 15.09.2015.
 */
class GoodTablePriceEventHandler implements EventHandler{
    private int columnIndex;
    private GoodTableModel model;
    private TextField field;

    public GoodTablePriceEventHandler(int columnIndex, GoodTableModel model, TextField textField){
        this.columnIndex = columnIndex;
        this.model = model;
        this.field = textField;
    }

    public void handle(Event e){
        int pos = field.getCaretPosition();
        this.model.setGoodPrice(columnIndex, field.getText());
        field.positionCaret(pos);
    }
}
