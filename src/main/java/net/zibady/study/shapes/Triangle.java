package net.zibady.study.shapes;

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
    public double getArea() {
        double p = (side1+side2+side3)/2;

        return Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (!this.getColor().equals(triangle.getColor())) return false;
        if (Double.compare(triangle.side1, side1) != 0) return false;
        if (Double.compare(triangle.side2, side2) != 0) return false;
        return Double.compare(triangle.side3, side3) == 0;
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
        temp = Double.doubleToLongBits(side3);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
