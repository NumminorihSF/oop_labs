package ru.kpetryaev.lab.lab7.task4;

/**
 * Created by NumminorihSF on 19.09.2015.
 */
public class Calc {
    double calc(int index, double a, double b){
        if (index == 0){
            return summ(a, b);
        }
        if (index == 1){
            return div(a, b);
        }
        return mult(a, b);

    }

    double summ(double a, double b){
        return a + b;
    }

    double div(double a, double b){
        return a / b;
    }

    double mult(double a, double b){
        return a * b;
    }
}
