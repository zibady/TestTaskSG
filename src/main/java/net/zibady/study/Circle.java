package net.zibady.study;

class Circle extends Shape{
    private final double diameter;

    Circle(String color, double diameter) {
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
