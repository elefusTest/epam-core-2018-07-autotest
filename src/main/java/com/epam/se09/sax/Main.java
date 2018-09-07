package com.epam.se09.sax;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        parserFactory.setValidating(false);

        SAXParser parser = parserFactory.newSAXParser();
        WebXMLParser handler = new WebXMLParser();
        parser.parse(Main.class.getResourceAsStream("./web.xml") , handler);
    }
}

