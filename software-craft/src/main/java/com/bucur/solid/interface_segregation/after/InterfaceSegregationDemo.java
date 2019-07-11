package com.bucur.solid.interface_segregation.after;

public class InterfaceSegregationDemo {

    public static void main(String[] args) {
        ToyBuilder.buildToyHouse();
        ToyBuilder.buildToyCar();
        ToyBuilder.buildToyPlane();
    }
}
