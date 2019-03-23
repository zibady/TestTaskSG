package net.zibady.study.validators;

import net.zibady.study.exceptions.ShapeException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShapeValidatorTest {
    private static ShapeValidator validator;

    @BeforeClass
    public static void setUp() {
        validator = new ShapeValidator();
    }

    @Test(expected = ShapeException.class)
    public void validateShapeWithWrongColor() throws Exception {
        validator.validate(null, 1.0);
    }
    @Test(expected = ShapeException.class)
    public void validateShapeWithEmptyColor() throws Exception {
        validator.validate("", 1.1);
    }

    @Test(expected = ShapeException.class)
    public void validateRectangleWithWrongColor() throws Exception {
        validator.validate(null, 1.2, 1.2);
    }
    @Test(expected = ShapeException.class)
    public void validateRectangleWithEmptyColor() throws Exception {
        validator.validate("", 1.0, 1.0);
    }

    @Test(expected = ShapeException.class)
    public void validateTriangleWithWrongColor() throws Exception {
        validator.validate(null, 1.0, 1.0, 1.0);
    }
    @Test(expected = ShapeException.class)
    public void validateTriangleWithEmptyColor() throws Exception {
        validator.validate("", 1.0, 1.0, 1.0);
    }

    @Test(expected = ShapeException.class)
    public void validateShapeWithSideOrDiameterLessThan_0() throws Exception {
        validator.validate("white", -1.0);
    }
    @Test(expected = ShapeException.class)
    public void validateRectangleWithSideOrDiameterLessThan_0() throws Exception {
        validator.validate("white", -1.0, 0.0);
    }
    @Test(expected = ShapeException.class)
    public void validateTriangleWithSideOrDiameterLessThan_0() throws Exception {
        validator.validate("white", -1.0, 0, -1000);
    }

    @Test(expected = ShapeException.class)
    public void validateNonExistenceTriangleWithWrongSides() throws Exception {
        validator.validate("white", 2.0, 1.0, 8.0);
    }

}