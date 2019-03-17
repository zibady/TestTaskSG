package net.zibady.study;

import net.zibady.study.exceptions.ShapeException;
import net.zibady.study.validators.ShapeValidators;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.concurrent.BlockingQueue;

class XMLHandler extends DefaultHandler {
    private BlockingQueue<Shape> shapes;

    private String elementName;
    private String shapeType;
    private int sideCount = 0;

    private String color;
    private double diameter;
    private double[] sides = new double[3];

    XMLHandler(BlockingQueue<Shape> shapes) {
        this.shapes = shapes;
    }

    BlockingQueue<Shape> getShapes() {
        return shapes;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //The logic of the reaction to the beginning of the element
        elementName = qName.toLowerCase();
        if ("circle triangle rectangle square".contains(qName.toLowerCase())) {
            shapeType = qName.toLowerCase();
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //The logic of the reaction to the ending of the element
        if ("circle triangle rectangle square".contains(qName.toLowerCase())) {
            if (shapeType != null)
                switch (shapeType) {
                    case "circle": {
                        try {
                            ShapeValidators.validate(color, diameter);
                            shapes.put(new Circle(color, diameter));
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        } catch (ShapeException e) {
                            System.out.printf("Wrong %s! %s%n", shapeType, e.getMessage());
                        } finally {
                            shapeType = null;
                            color = null;
                            diameter = 0;
                        }
                    }
                    break;
                    case "triangle": {
                        try {
                            ShapeValidators.validate(color, sides[0], sides[1], sides[2]);
                            shapes.put(new Triangle(color, sides[0], sides[1], sides[2]));
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        } catch (ShapeException e) {
                            System.out.printf("Wrong %s! %s%n", shapeType, e.getMessage());
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
                        try {
                            ShapeValidators.validate(color, sides[0], sides[1]);
                            shapes.put(new Rectangle(color, sides[0], sides[1]));
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        } catch (ShapeException e) {
                            System.out.printf("Wrong %s! %s%n", shapeType, e.getMessage());
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
                        try {
                            ShapeValidators.validate(color, sides[0]);
                            shapes.put(new Square(color, sides[0]));
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        } catch (ShapeException e) {
                            System.out.printf("Wrong %s! %s%n", shapeType, e.getMessage());
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
        //The logic of the reaction to the text inside the element
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

