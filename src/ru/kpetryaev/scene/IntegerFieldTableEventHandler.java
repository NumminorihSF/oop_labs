package ru.kpetryaev.scene;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;


/**
 * Created by NumminorihSF on 15.09.2015.
 */
class IntegerFieldTableEventHandler implements EventHandler{
    private int i;
    private int j;
    private IntegerFieldTableModel model;
    private TextField field;

    public IntegerFieldTableEventHandler(int i, int j, IntegerFieldTableModel model, TextField textField){
        this.i = i;
        this.j = j;
        this.model = model;
        this.field = textField;
    }

    public void handle(Event e){
        int pos = field.getCaretPosition();
        this.model.setElement(i, j, field.getText());
        field.positionCaret(pos);

    }
}
