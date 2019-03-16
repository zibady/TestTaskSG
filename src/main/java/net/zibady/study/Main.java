package net.zibady.study;

import net.zibady.study.validators.XmlValidator;

import java.io.IOException;
import java.util.List;

public class Main {
    private static int count = 0;

    public static void main(String[] args) throws IOException{

        new XmlValidator().validate(args[0]);
        new XmlParser().parseXmlToObjects(args[0]);

        List<Shape> shapes = new XmlParser().parseXmlToObjects(args[0]);
        shapes.forEach(Main::printShape);

    }

    private static void printShape(Shape shape) {
        System.out.printf("%d: %s - %.2f%n", ++count, shape.getColor(), shape.getArea());
    }

    private static double roundArea(double area) {
        return Math.round(area * 100) / 100;
    }
}
