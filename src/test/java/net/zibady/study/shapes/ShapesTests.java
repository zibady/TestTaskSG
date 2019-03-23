package net.zibady.study.shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShapesTests {
    @Test
    public void getCorrectCircleArea() throws Exception {
        Shape circle = new Circle("white", 4);
        double expected = 12.57;
        double actual = circle.getArea();
        assertEquals(expected, actual, 0.01);
    }
    @Test
    public void getCorrectRectangleArea() throws Exception {
        Shape rectangle = new Rectangle("white", 4, 2);
        double expected = 8.00;
        double actual = rectangle.getArea();
        assertEquals(expected, actual, 0.01);
    }
    @Test
    public void getCorrectSquareArea() throws Exception {
        Shape square = new Square("white", 4);
        double expected = 16.00;
        double actual = square.getArea();
        assertEquals(expected, actual, 0.01);
    }
    @Test
    public void getCorrectTriangleArea() throws Exception {
        Shape triangle = new Triangle("white", 2, 2, 2);
        double expected = 1.73;
        double actual = triangle.getArea();
        assertEquals(expected, actual, 0.01);
    }

}