package net.zibady.study;
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
    protected double getArea() {

        return Math.PI * Math.pow(diameter/2, 2);
    }
}
