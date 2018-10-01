package com.epam.se09.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Optional;

public class WebXMLParser extends DefaultHandler {

    private StringBuilder accumulator = new StringBuilder();
    private String servletName;
    private String servletClass;
    private String servletId;

    @Override
    public void startDocument() {
        System.out.println("Parsing started");
    }

    @Override
    public void startElement(String uri, String withoutURI, String fullName, Attributes attributes) {
        accumulator.setLength(0);
        if ("servlet".equals(fullName)) {
            servletId = attributes.getValue("id");
        }
    }

    @Override
    public void characters(char[] buffer, int start, int length) {
        accumulator.append(buffer, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String fullName) {
        switch (fullName) {
            case "servlet-name":
                servletName = accumulator.toString().trim();
                break;

            case "servlet-class":
                servletClass = accumulator.toString().trim();
                break;

            case "servlet":
                servletId = Optional.ofNullable(servletId)
                                    .map(id -> " (id=" + id + ")")
                                    .orElse("");
                System.out.printf("Servlet %s %s: %s%n", servletName, servletId, servletClass);
                break;
        }
    }

    @Override
    public void endDocument() {
        System.out.println("Parsing ended");
    }

    @Override
    public void warning(SAXParseException exception) {
        System.err.println("WARNING: line " + exception.getLineNumber() + ": " + exception.getMessage());
    }

    @Override
    public void error(SAXParseException exception) {
        System.err.println("ERROR: line " + exception.getLineNumber() + ": " + exception.getMessage());
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        System.err.println("FATAL: line " + exception.getLineNumber() + ": " + exception.getMessage());
        throw exception;
    }
}

