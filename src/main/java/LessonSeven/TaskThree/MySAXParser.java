package LessonSeven.TaskThree;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MySAXParser {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        String fileName = "src/LessonSeven/TaskThree/city.xml";
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        List<Adress> adressList = new ArrayList<>();
List<String> strings = new ArrayList<>();

        DefaultHandler myHandler = new DefaultHandler() {
            String thisElement;
            Adress adress = new Adress();

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                thisElement = qName;
                strings.add(thisElement);
                if (thisElement.equals("adress")) {
                    adress = new Adress();
                }
                if (thisElement.equals("city")) {
                    adress.setCitySize(attributes.getValue("size"));
                }
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                if (thisElement.equals("city")) {
                    adress.setCity(new String(ch, start, length));
                }

                if (thisElement.equals("street")) {
                    adress.setStreet(new String(ch, start, length));
                }

                if (thisElement.equals("house")) {
                    adress.setHouse(new String(ch, start, length));
                    adressList.add(adress);
                }
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                thisElement = "";
            }
        };
        parser.parse(new File(fileName), myHandler);
        adressList.stream().forEach(System.out::println);
        strings.stream().forEach(System.out::println);
    }
}

