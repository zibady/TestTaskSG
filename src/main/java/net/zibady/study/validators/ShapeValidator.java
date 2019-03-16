package net.zibady.study.validators;

import net.zibady.study.exceptions.ShapeException;

public class ShapeValidator {

    public static void validate(String color, double a, double b, double c) throws ShapeException {

        if (color == null || color.isEmpty()) {
            throw new ShapeException("The shape should have a color!");
        } else if (a <= 0 || b <= 0 || c <= 0) {
            throw new ShapeException(
                String.format("Triangle side can't be 0 or less: side1 - %.2f side2 - %.2f side3 - %.2f", a, b, c));
        } else if (a+b < c || a+c < b || b+c < a ) {
            throw new ShapeException("The sum of any two sides of triangle must be greater than third side!");
        }
    }

    public static void validate(String color, double side1, double side2) throws ShapeException {

        if (color == null || color.isEmpty()) {
            throw new ShapeException("The shape should have a color!");
        } else if (side1 <= 0 || side2 <= 0) {
            throw new ShapeException(String.format("Rectangle side can't be 0 or less: side1 - %.2f side2 - %.2f",
                                                    side1, side2));
        }
    }

    public static void validate(String color, double side) throws ShapeException {

        if (color == null || color.isEmpty()) {
            throw new ShapeException("The shape should have a color!");
        } else if (side <= 0 ) {
            throw new ShapeException(String.format("Shade side or diameter can't be 0 or less: side1 - %.2f", side));
        }

    }
// private void validate(Circle circle) {
//
//        if (circle.getColor() == null || circle.getColor().isEmpty()) {
//            throw new ShapeException("The shape should have a color!");
//        } else if (circle.getDiameter() <= 0) {
//            throw new ShapeException("Diameter can't be 0 or less");
//        }
//    }
//
//    private void validate(Triangle triangle) {
//
//        final double a = triangle.getSide1();
//        final double b = triangle.getSide2();
//        final double c = triangle.getSide3();
//
//        if (triangle.getColor() == null || triangle.getColor().isEmpty()) {
//            throw new ShapeException("The shape should have a color!");
//        } else if (a <= 0 || b <= 0 || c <= 0) {
//            throw new ShapeException(
//                String.format("Triangle side can't be 0 or less: side1 - %.2f side2 - %.2f side3 - %.2f", a, b, c));
//        } else if (a+b < c || a+c < b || b+c < a ) {
//            throw new ShapeException("The sum of any two sides of triangle must be greater than third side!");
//        }
//    }
//
//    private void validate(Rectangle rectangle) {
//
//        if (rectangle.getColor() == null || rectangle.getColor().isEmpty()) {
//            throw new ShapeException("The shape should have a color!");
//        } else if (rectangle.getSide1() <= 0 || rectangle.getSide2() <= 0) {
//            throw new ShapeException(String.format("Rectangle side can't be 0 or less: side1 - %.2f side2 - %.2f",
//                                                    rectangle.getSide1(), rectangle.getSide2()));
//        }
//    }
//
//    private void validate(Square square) {
//
//        if (square.getColor() == null || square.getColor().isEmpty()) {
//            throw new ShapeException("The shape should have a color!");
//        } else if (square.getSide() <= 0 ) {
//            throw new ShapeException(String.format("Square side can't be 0 or less: side1 - %.2f", square.getSide()));
//        }
//
//    }
}
