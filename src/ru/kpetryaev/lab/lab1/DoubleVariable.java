package ru.kpetryaev.lab.lab1;

import java.util.Scanner;


public class DoubleVariable {
    private static Scanner scanner = new Scanner(System.in);
    private String name;
    private double value;

    double getValue(){
        return this.value;
    }

    double setValueFromStdIn(){
        System.out.print("Set " + this.name + ": ");
        String input = DoubleVariable.scanner.next();
        input = input.replace(',', '.');
        try {
            this.value = Double.parseDouble(input);
            return this.value;
        }
        catch (NumberFormatException err)
        {
            System.out.println("Should be the number.");
            return this.setValueFromStdIn();
        }
    }

    public DoubleVariable(String name){
        this.name = name;
    }

}

