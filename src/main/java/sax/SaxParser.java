package sax;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SaxParser {

    private static final String XML_DOC_PATH = "testfile.xml";

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXHandler handler = new SAXHandler();
        SAXParser parser = factory.newSAXParser();
        parser.parse(XML_DOC_PATH, handler);
        System.out.println(handler.journal);
    }

}
