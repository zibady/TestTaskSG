package net.zibady.study;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.BlockingQueue;

class XmlParser {

    BlockingQueue<Shape> parseXmlToObjects(String fileXML, BlockingQueue<Shape> shapes) throws IOException {
        XMLHandler handler = new XMLHandler(shapes);
        try (InputStream src = new FileInputStream(fileXML)) {

            try {
                SAXParserFactory factory = SAXParserFactory.newInstance();
                SAXParser saxParser = factory.newSAXParser();

                saxParser.parse(src, handler);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return handler.getShapes();

    }

}
