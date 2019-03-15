package net.zibady.study;

public class Triangle extends Shape{
    private final double side1;
    private final double side2;
    private final double side3;

    public Triangle(String color, double side1, double side2, double side3) {
        super(color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    @Override
    protected double getArea() {
        double p = (side1+side2+side3)/2;

        return Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
    }
}
