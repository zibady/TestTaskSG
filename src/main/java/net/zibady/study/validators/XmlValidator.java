package net.zibady.study.validators;

import org.xml.sax.SAXException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XmlValidator {

    public XmlValidator() {
    }

    public void validate (String xmlFile) /*throws SAXException, IOException*/{
        // Створення екземпляра фабрики XML Schema
        SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");

        // Компіляція схеми
        try {
            File schemaLocation = new File("shapes.xsd");
            Schema schema = factory.newSchema(schemaLocation);

            // Створення валідатора для схеми
            Validator validator = schema.newValidator();

            // Розбір провіряємого документа
//             Source source = new StreamSource(xmlFile);

            // Валідація документа
            validator.validate(new StreamSource(xmlFile));
//            System.out.println(xmlFile + " is valid.");
        } catch (SAXException e) {
            System.out.println(xmlFile + " is not valid because: \n" + e.getMessage());
//            throw new RuntimeException();
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Can't open " + xmlFile + " because: \n" + e.getMessage());
//            throw new RuntimeException();
            System.exit(0);
        }
    }
}
