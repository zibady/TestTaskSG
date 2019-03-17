package net.zibady.study;

import net.zibady.study.validators.XmlValidator;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {
    private static ArrayBlockingQueue<Shape> shapes = new ArrayBlockingQueue<>(100);

    public static void main(String[] args) throws IOException{

        // Checking xml-file for match xsd schema.
        new XmlValidator().validate(args[0]);

        XmlParser xmlParser = new XmlParser();

        Runnable runnable = () -> {
            for (int i = 1; ; i++) {
                try {
                    printShape(shapes.take(), i);
                } catch (InterruptedException e) {
                    return;
                }
            }
        };
        Thread printThread = new Thread(runnable);
        printThread.start();

        xmlParser.parseXmlToObjects(args[0], shapes);

        while (!shapes.isEmpty()) { /*NOP*/}
        printThread.interrupt();
    }

    private static void printShape(Shape shape, int count) {
        System.out.printf("%d: %s - %.2f%n", count, shape.getColor(), shape.getArea());
    }
}
