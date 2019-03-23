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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circle circle = (Circle) o;

        return this.getColor().equals(circle.getColor()) && Double.compare(circle.diameter, diameter) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = this.getColor().hashCode();
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(diameter);
        return 31 * result + (int) (temp ^ (temp >>> 32));
    }
}
