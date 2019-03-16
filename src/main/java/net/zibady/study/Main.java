package net.zibady.study;

import net.zibady.study.validators.XmlValidator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static AtomicInteger count = new AtomicInteger(1);

    public static void main(String[] args) throws IOException{

        new XmlValidator().validate(args[0]);
        XmlParser xmlParser = new XmlParser();


//        List<Shape> shapes = new ArrayList<>();
        Queue<Shape> shapes = new ArrayBlockingQueue<>(100);
        xmlParser.parseXmlToObjects(args[0], shapes);
        shapes.forEach(Main::printShape);

    }

    private static void printShape(Shape shape) {
        System.out.printf("%d: %s - %.2f%n", count.getAndIncrement(), shape.getColor(), shape.getArea());
    }

    private static double roundArea(double area) {
        return Math.round(area * 100) / 100;
    }
}
