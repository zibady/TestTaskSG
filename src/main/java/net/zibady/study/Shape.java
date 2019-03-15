package net.zibady.study;

public abstract class Shape {
    private final String color;

    Shape(String color) {
        this.color = color;
    }

    public String getColor () {
        return color;
    }

    protected abstract double getArea();

}
