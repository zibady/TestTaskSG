package net.zibady.study.xml;

import net.zibady.study.shapes.Shape;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.BlockingQueue;

public class XmlParser {

    public BlockingQueue<Shape> parseXmlToObjects(String fileXML, BlockingQueue<Shape> shapes) {
        XmlHandler handler = new XmlHandler(shapes);
        try (InputStream src = new FileInputStream(fileXML)) {

            try {
                SAXParserFactory factory = SAXParserFactory.newInstance();
                SAXParser saxParser = factory.newSAXParser();
                saxParser.parse(src, handler);
            } catch (SAXException | ParserConfigurationException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            System.out.println("Can't open " + fileXML + " because: \n" + e.getMessage());
            System.exit(0);
        }
        return handler.getShapes();

    }

}
