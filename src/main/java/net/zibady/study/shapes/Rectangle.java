package net.zibady.study.shapes;

public class Rectangle extends Shape{
    private final double side1;
    private final double side2;

    public Rectangle(String color, double side1, double side2) {
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
    public double getArea() {

        return side1 * side2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rectangle rectangle = (Rectangle) o;

        if (!this.getColor().equals(rectangle.getColor())) return false;
        if (Double.compare(rectangle.side1, side1) != 0) return false;
        return Double.compare(rectangle.side2, side2) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = this.getColor().hashCode();
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(side1);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(side2);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
