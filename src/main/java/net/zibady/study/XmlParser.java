package net.zibady.study;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class XmlParser {

    private List<Shape> shapes = new ArrayList<>();
    private int count = 0;

    public List<Shape> parseXmlToObjects(String fileXML) throws IOException {
        try (InputStream src = new FileInputStream(fileXML)) {
            try {
                SAXParserFactory factory = SAXParserFactory.newInstance();
                SAXParser saxParser = factory.newSAXParser();
                saxParser.parse(src, new XMLHandler());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return shapes;

    }

    private static class XMLHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            //Логіка реакції на початок елемента
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            //Логіка реакції на кінець елемента
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            //Логіка реакції на текст між елементами
        }
    }
}
