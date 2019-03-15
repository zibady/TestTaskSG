package net.zibady.study;

public class Square extends Shape{
    private final double side;

    public Square(String color, double side) {
        super(color);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    @Override
    protected double getArea() {

        return Math.pow(side, 2);
    }
}
