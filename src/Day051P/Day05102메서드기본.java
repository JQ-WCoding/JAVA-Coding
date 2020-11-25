package Day051P;

class Ex03 {
    int x, y;

    public void setNums(int num1, int num2) {
        x = num1;
        y = num2;
    }

    public void printNums() {
        System.out.println(x + " " + y);
    }
}

public class Day05102메서드기본 {
    public static void main(String[] args) {
        Ex03 ex = new Ex03();

        ex.x = 10;
        ex.y = 20;
        System.out.println(ex.x + " " + ex.y);

        Ex03 ex2 = new Ex03();
        ex2.setNums(10, 20);
        ex2.printNums();

        Calculator calculator = new Calculator();
        System.out.println(calculator.plus(1, 2));
    }
}

class Calculator {
    double x, y, result;

    public double plus(double num1, double num2) {
        return (num1 + num2);
    }

    public double minus(double num1, double num2) {
        return (num1 - num2);
    }

    public double multiply(double num1, double num2) {
        return (num1 * num2);
    }

    public double divide(double num1, double num2) {
        return (num1 / num2);
    }
}