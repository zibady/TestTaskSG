package net.zibady.study;

import net.zibady.study.exceptions.ShapeException;
import net.zibady.study.validators.ShapeValidator;
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
        XMLHandler handler = new XMLHandler();
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

    private static class XMLHandler extends DefaultHandler {
        private List<Shape> shapes = new ArrayList<>();
        private int count = 0;

        private String elementName;
        private String shapeType;
        private int sideCount = 0;

        private String color;
        private double diameter;
        private double[] sides = new double[3];

        public List<Shape> getShapes() {
            return shapes;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            //Логіка реакції на початок елемента
            elementName = qName.toLowerCase();
            if ("circle triangle rectangle square".contains(qName.toLowerCase())) {
//                isInsideOfShape = true;
                shapeType = qName.toLowerCase();
            }

        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            //Логіка реакції на кінець елемента
            if ("circle triangle rectangle square".contains(qName.toLowerCase())) {
//                isInsideOfShape = false;
                if (shapeType != null)
                switch (shapeType) {
                    case "circle": {
                        count++;
                        try {
                            ShapeValidator.validate(color, diameter);
                            shapes.add(new Circle(color, diameter));
                        } catch (ShapeException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                    case "triangle": {
                        count++;
                        try {
                            ShapeValidator.validate(color, sides[0], sides[1], sides[2]);
                            shapes.add(new Triangle(color, sides[0], sides[1], sides[2]));
                        } catch (ShapeException e) {
                            System.out.printf("%d: %s%n", count, e.getMessage());
                        }
                        sideCount = 0;
                    }
                    break;
                    case "rectangle": {
                        count++;
                        try {
                            ShapeValidator.validate(color, sides[0], sides[1]);
                        } catch (ShapeException e) {
                            e.printStackTrace();
                        }
                        shapes.add(new Rectangle(color, sides[0], sides[1]));
                        sideCount = 0;
                    }
                    break;
                    case "square": {
                        count++;
                        try {
                            ShapeValidator.validate(color, sides[0]);
                        } catch (ShapeException e) {
                            e.printStackTrace();
                        }
                        shapes.add(new Square(color, sides[0]));
                        sideCount = 0;
                    }
                    break;
                }
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            //Логіка реакції на текст між елементами
                String information = new String(ch, start, length);
                information = information.replace("\n", "").trim();
                if (!information.isEmpty()) {
                    if (shapeType != null)
                    switch (shapeType) {
                        case "circle": {
                            if ("color".equals(elementName))
                                color = information;
                            else if ("diameter".equals(elementName))
                                diameter = Double.parseDouble(information);
                        }
                        break;
                        case "triangle": {
                            if ("color".equals(elementName))
                                color = information;
                            else if ("side".equals(elementName))
                                sides[sideCount++] = Double.parseDouble(information);
                        }
                        break;
                        case "rectangle": {
                            if ("color".equals(elementName))
                                color = information;
                            else if ("side".equals(elementName))
                                sides[sideCount++] = Double.parseDouble(information);
                        }
                        break;
                        case "square": {
                            if ("color".equals(elementName))
                                color = information;
                            else if ("side".equals(elementName))
                                sides[sideCount] = Double.parseDouble(information);
                        }
                        break;
                    }
                }
        }
    }
}
