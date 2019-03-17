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
        // Create a factory for the W3C XML Schema language.
        SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");

        // Compile the schema.
        try {
            File schemaLocation = new File("shapes.xsd");
            Schema schema = factory.newSchema(schemaLocation);

            // Get a validator from the schema.
            Validator validator = schema.newValidator();

            // Parse and check the document.
            validator.validate(new StreamSource(xmlFile));
        } catch (SAXException e) {
            System.out.println(xmlFile + " is not valid because: \n" + e.getMessage());
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Can't open " + xmlFile + " because: \n" + e.getMessage());
            System.exit(0);
        }
    }
}
