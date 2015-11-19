package ru.kpetryaev.lab.lab3;


import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class Presenter {
    @FXML public TextArea result;
    @FXML public TextField a;
    @FXML public TextField b;
    @FXML public TextField c;

    private String solve(){
        double disk, av, bv, cv;

        try {
            av = Double.parseDouble(a.getText().trim());
            bv = Double.parseDouble(b.getText().trim());
            cv = Double.parseDouble(c.getText().trim());
        }
        catch (NumberFormatException err)
        {
            return "Неверно заданы значения";
        }

        if (av == 0) {
            return "A=" + av + ", B=" + bv + ", C=" + cv + ".\tУравнение не квадратное";
        }
        disk = bv * bv - 4 * av * cv;
        if (disk < 0) {
            return "A=" + av + ", B=" + bv + ", C=" + cv + ".\tНет действительных корней";
        }
        else if (disk == 0) {
            return "A=" + av + ", B=" + bv + ", C=" + cv + ".\tx = " + (-bv/(2*av));
        }
        else {
            disk = Math.sqrt(disk);
            return "A=" + av + ", B=" + bv + ", C=" + cv + ".\tx1 = " + ((-bv+disk)/(2*av)) + " x2 = "+((-bv-disk)/(2*av));
        }
    }

    @FXML
    protected void handleSolve(KeyEvent event) {
        result.setText(solve());
    }
}
