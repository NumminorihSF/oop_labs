package ru.kpetryaev.lab.lab7.task1;

/**
 * Created by NumminorihSF on 19.09.2015.
 */
public class Triangle {
    int cathetus1;
    int cathetus2;

    Triangle(int cathetus1, int cathetus2){
        this.cathetus1 = cathetus1;
        this.cathetus2 = cathetus2;
    }

    double getHypotenuse(){
        return Math.sqrt(Math.pow(cathetus1, 2) + Math.pow(cathetus2, 2));
    }
}
