package net.zibady.study.xml;

import net.zibady.study.shapes.Shape;
import net.zibady.study.validators.ShapeValidator;
import org.junit.Test;

import java.util.concurrent.BlockingQueue;

import static org.junit.Assert.*;

public class XmlHandlerTest {
    private BlockingQueue<Shape> expected;
    private ShapeValidator validator = new ShapeValidator();


    @Test
    public void getShapesTest() throws Exception {
        XmlHandler xmlHandler = new XmlHandler(expected);
        assertSame(expected, xmlHandler.getShapes());
    }
}