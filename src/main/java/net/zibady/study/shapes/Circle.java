package net.zibady.study.shapes;

public class Circle extends Shape{
    private final double diameter;

    public Circle(String color, double diameter) {
        super(color);
        this.diameter = diameter;
    }

    public double getDiameter() {
        return diameter;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(diameter/2, 2);
    }
}
