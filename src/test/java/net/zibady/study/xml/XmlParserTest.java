package net.zibady.study.xml;

import net.zibady.study.shapes.*;
import net.zibady.study.validators.XmlValidator;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Collections;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static org.junit.Assert.*;

public class XmlParserTest {
    @Test
    public void parseXmlToObjectsCorrectTest() throws Exception {
        XmlParser xmlParser = new XmlParser();
        String src = "test.xml";

        ArrayBlockingQueue<Shape> expected = new ArrayBlockingQueue<>(5);
            expected.put(new Triangle("red", 5, 6, 1.2));
            expected.put(new Circle("orange", 4.5));
            expected.put(new Rectangle("white", 5.2, 3));
            expected.put(new Square("black", 5.8));

        ArrayBlockingQueue<Shape> actual = new ArrayBlockingQueue<>(5);
        xmlParser.parseXmlToObjects(src, actual);

        assertEquals(expected.size(), actual.size());
        assertTrue(expected.containsAll(actual));
    }

}