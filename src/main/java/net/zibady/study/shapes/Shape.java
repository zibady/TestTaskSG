package net.zibady.study.shapes;

public abstract class Shape {
    private final String color;

    Shape(String color) {
        this.color = color;
    }

    public String getColor () {
        return color;
    }

    public abstract double getArea();

}
