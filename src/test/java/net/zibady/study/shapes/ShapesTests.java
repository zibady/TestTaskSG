package net.zibady.study.shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShapesTests {
    @Test
    public void getCircleArea() throws Exception {
        Shape circle = new Circle("white", 4);
        assertEquals(Math.PI*4, circle.getArea(), 0.001);
    }
    @Test
    public void getRectangleArea() throws Exception {
        Shape rectangle = new Rectangle("white", 4, 2);
        assertEquals(8.00, rectangle.getArea(), 0.01);
    }
    @Test
    public void getSquareArea() throws Exception {
        Shape square = new Square("white", 4);
        assertEquals(16.00, square.getArea(), 0.01);
    }
    @Test
    public void getTriangleArea() throws Exception {
        Shape triangle = new Triangle("white", 2, 2, 2);
        assertEquals(1.73, triangle.getArea(), 0.01);
    }

}