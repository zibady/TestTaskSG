package net.zibady.study;

import net.zibady.study.validators.XmlValidator;

public class Main {
    private int count = 0;

    public static void main(String[] args) {

        new XmlValidator().validate(args[0]);


    }

    void printShape(Shape shape) {
        System.out.printf("%d: %s - %.2f%n", ++count, shape.getColor(), roundArea(shape.getArea()));
    }

    private double roundArea(double area) {
        return Math.round(area * 100) / 100;
    }
}
