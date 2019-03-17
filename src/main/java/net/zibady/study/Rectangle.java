package net.zibady.study;

class Rectangle extends Shape{
    private final double side1;
    private final double side2;

    Rectangle(String color, double side1, double side2) {
        super(color);
        this.side1 = side1;
        this.side2 = side2;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    @Override
    protected double getArea() {

        return side1 * side2;
    }
}
