package ru.kpetryaev.scene;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;


/**
 * Created by NumminorihSF on 15.09.2015.
 */
class GoodTableCountEventHandler implements EventHandler{
    private int columnIndex;
    private GoodTableModel model;
    private TextField field;

    public GoodTableCountEventHandler(int columnIndex, GoodTableModel model, TextField textField){
        this.columnIndex = columnIndex;
        this.model = model;
        this.field = textField;
    }

    public void handle(Event e){
        int pos = field.getCaretPosition();
        this.model.setGoodCount(columnIndex, field.getText());
        field.positionCaret(pos);
    }
}
