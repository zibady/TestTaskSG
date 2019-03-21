package net.zibady.study.validators;

import net.zibady.study.exceptions.ShapeException;

public class ShapeValidator {

    public void validate(String color, double a, double b, double c) throws ShapeException {

        if (color == null || color.isEmpty()) {
            throw new ShapeException("The shape should have a color!");
        }
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new ShapeException(
                String.format("Triangle side can't be 0 or less: side - %.2f, side - %.2f, side - %.2f", a, b, c));
        } else if (a+b < c || a+c < b || b+c < a ) {
            throw new ShapeException("The sum of any two sides of triangle must be greater than third side!");
        }
    }

    public void validate(String color, double side1, double side2) throws ShapeException {

        if (color == null || color.isEmpty()) {
            throw new ShapeException("The shape should have a color!");
        }
        if (side1 <= 0 || side2 <= 0) {
            throw new ShapeException(String.format("Rectangle side can't be 0 or less: side, - %.2f side, - %.2f",
                                                    side1, side2));
        }
    }

    public void validate(String color, double side) throws ShapeException {

        if (color == null || color.isEmpty()) {
            throw new ShapeException("The shape should have a color!");
        }
        if (side <= 0 ) {
            throw new ShapeException(String.format("Shade side or diameter can't be 0 or less: %.2f", side));
        }

    }
}
