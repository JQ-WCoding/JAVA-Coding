package Day069P.Day06902다형성;

import java.util.Scanner;

abstract class Shape {
    int x;
    int y;

    public void move() {
    }

    public abstract void draw();
}

class Point extends Shape {
    @Override
    public void draw() {
        System.out.println("점을 찍는다");
    }
}

class Line extends Shape {
    @Override
    public void draw() {
        System.out.println("선을 그린다");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("원을 그린다");
    }
}

class Rect extends Shape {
    @Override
    public void draw() {
        System.out.println("사각형을 그린다");
    }
}

class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("삼각형을 그린다");
    }
}

public class Day06902다형성 {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Point(), new Line(), new Circle(), new Rect(), new Triangle()
        };

        Scanner scanner = new Scanner(System.in);

        System.out.println("원하는 작업을 선택하세요");
        int menu = scanner.nextInt();

        shapes[menu - 1].draw();
    }
}
