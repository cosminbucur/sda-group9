package com.bucur.cohesion;

public class DemoHighCohesion {

    public static void main(String[] args) {
        Display display = new Display();
        display.show();
    }
}

class Multiplier {
    int a = 5;
    int b = 5;

    public int multiply(int a, int b) {
        this.a = a;
        this.b = b;
        return a * b;
    }
}

class Display {

    public void show() {
        Multiplier multiplier = new Multiplier();
        System.out.println(multiplier.multiply(5, 5));
    }

}