package net.zibady.study.validators;

import net.zibady.study.exceptions.ShapeException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShapeValidatorTest {

    @Test(expected = ShapeException.class)
    public void validateShapeWithWrongColor() throws Exception {
        ShapeValidator validator = new ShapeValidator();
        validator.validate(null, 1);
    }
    @Test(expected = ShapeException.class)
    public void validateShapeWithEmptyColor() throws Exception {
        ShapeValidator validator = new ShapeValidator();
        validator.validate("", 1);
    }

    @Test(expected = ShapeException.class)
    public void validateRectangleWithWrongColor() throws Exception {
        ShapeValidator validator = new ShapeValidator();
        validator.validate(null, 1, 1);
    }
    @Test(expected = ShapeException.class)
    public void validateRectangleWithEmptyColor() throws Exception {
        ShapeValidator validator = new ShapeValidator();
        validator.validate("", 1, 1);
    }

    @Test(expected = ShapeException.class)
    public void validateTriangleWithWrongColor() throws Exception {
        ShapeValidator validator = new ShapeValidator();
        validator.validate(null, 1, 1, 1);
    }
    @Test(expected = ShapeException.class)
    public void validateTriangleWithEmptyColor() throws Exception {
        ShapeValidator validator = new ShapeValidator();
        validator.validate("", 1, 1, 1);
    }

    @Test(expected = ShapeException.class)
    public void validateShapeWithSideOrDiameterLessThan_0() throws Exception {
        ShapeValidator validator = new ShapeValidator();
        validator.validate("white", -1);
    }
    @Test(expected = ShapeException.class)
    public void validateRectangleWithSideOrDiameterLessThan_0() throws Exception {
        ShapeValidator validator = new ShapeValidator();
        validator.validate("white", -1, 0);
    }
    @Test(expected = ShapeException.class)
    public void validateTriangleWithSideOrDiameterLessThan_0() throws Exception {
        ShapeValidator validator = new ShapeValidator();
        validator.validate("white", -1, 0, -1000);
    }

    @Test(expected = ShapeException.class)
    public void validateNonExistenceTriangleWithWrongSides() throws Exception {
        ShapeValidator validator = new ShapeValidator();
        validator.validate("white", 2, 1, 8);
    }

}