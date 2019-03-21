package net.zibady.study.shapes;

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
    public double getArea() {

        return Math.pow(side, 2);
    }
}
