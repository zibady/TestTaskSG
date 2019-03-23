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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Square square = (Square) o;

        return this.getColor().equals(square.getColor()) && Double.compare(square.side, side) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = this.getColor().hashCode();
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(side);
        return 31 * result + (int) (temp ^ (temp >>> 32));
    }
}
