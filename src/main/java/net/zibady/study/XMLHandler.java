package net.zibady.study;

import net.zibady.study.exceptions.ShapeException;
import net.zibady.study.validators.ShapeValidators;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Collection;

public class XMLHandler extends DefaultHandler {
    private Collection<Shape> shapes;
    private int count = 0;

    private String elementName;
    private String shapeType;
    private int sideCount = 0;

    private String color;
    private double diameter;
    private double[] sides = new double[3];

    public XMLHandler(Collection<Shape> shapes) {
        this.shapes = shapes;
    }

    public Collection<Shape> getShapes() {
        return shapes;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //Логіка реакції на початок елемента
        elementName = qName.toLowerCase();
        if ("circle triangle rectangle square".contains(qName.toLowerCase())) {
            shapeType = qName.toLowerCase();
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //Логіка реакції на кінець елемента
        if ("circle triangle rectangle square".contains(qName.toLowerCase())) {
            if (shapeType != null)
                switch (shapeType) {
                    case "circle": {
                        count++;
                        try {
                            ShapeValidators.validate(color, diameter);
                            shapes.add(new Circle(color, diameter));
                        } catch (ShapeException e) {
                            e.printStackTrace();
                        } finally {
                            shapeType = null;
                            color = null;
                            diameter = 0;
                        }
                    }
                    break;
                    case "triangle": {
                        count++;
                        try {
                            ShapeValidators.validate(color, sides[0], sides[1], sides[2]);
                            shapes.add(new Triangle(color, sides[0], sides[1], sides[2]));
                        } catch (ShapeException e) {
                            System.out.printf("%d: %s%n", Main.count.getAndIncrement(), e.getMessage());
                        } finally {
                            shapeType = null;
                            color = null;
                            sideCount = 0;
                            sides[0] = 0;
                            sides[1] = 0;
                            sides[2] = 0;
                        }
                    }
                    break;
                    case "rectangle": {
                        count++;
                        try {
                            ShapeValidators.validate(color, sides[0], sides[1]);
                            shapes.add(new Rectangle(color, sides[0], sides[1]));
                        } catch (ShapeException e) {
                            System.out.printf("%d: %s%n", Main.count.getAndIncrement(), e.getMessage());
                        } finally {
                            shapeType = null;
                            color = null;
                            sideCount = 0;
                            sides[0] = 0;
                            sides[1] = 0;
                        }
                    }
                    break;
                    case "square": {
                        count++;
                        try {
                            ShapeValidators.validate(color, sides[0]);
                            shapes.add(new Square(color, sides[0]));
                        } catch (ShapeException e) {
                            System.out.printf("%d: %s%n", Main.count.getAndIncrement(), e.getMessage());
                        } finally {
                            shapeType = null;
                            sideCount = 0;
                            color = null;
                            sides[0] = 0;
                        }
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

