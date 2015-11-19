package ru.kpetryaev.lab.lab1;

public class Main {

    private static DoubleVariable varA = new DoubleVariable("A");
    private static DoubleVariable varB = new DoubleVariable("B");
    private static DoubleVariable varC = new DoubleVariable("C");

    private static String solve(){
        double  disk,
                a = varA.getValue(),
                b = varB.getValue(),
                c = varC.getValue();

        if (a == 0) {
            return "This is not like A*x^2 + B*x + C = 0.";

        }

        disk = b * b - 4 * a * c;

        if (disk < 0) {
            return "There is not real answer.";
        }
        else if (disk == 0) {
            return "x = "+(-b/(2*a)) + '.';
        }
        else {
            disk = Math.sqrt(disk);
            return "x1 = "+((-b+disk)/(2*a)) + "\tx2 = "+((-b-disk)/(2*a)) + '.';

        }
    }

    private static void showResult(String result){
        System.out.println('\t' + result);
    }

    private static void getVars(){
        varA.setValueFromStdIn();
        varB.setValueFromStdIn();
        varC.setValueFromStdIn();
    }


    public static void main(String[] args) {
        System.out.println("Let\'s solve the equation.");
        System.out.println("It should be like A*x^2 + B*x + C = 0.");
        Main.getVars();
        Main.showResult(Main.solve());
        System.out.println("Close.");
    }
}
