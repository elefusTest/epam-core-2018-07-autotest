package com.epam.se09.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;

public class MarshalMain {

    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Student.class);
            Marshaller m = context.createMarshaller();
            Student.Address addr = new Student.Address("BLR", "Minsk","Skoriny 4");
            Student s = new Student("mendig", "Dmitry Terenya", "rfe", 2066394, addr);// объект
            m.marshal(s, new FileOutputStream("stud.xml"));
            m.marshal(s, System.out);// на консоль
            System.out.println("XML-файл создан");
        } catch (FileNotFoundException e) {
            System.out.println("XML-файл не найден");
            e.printStackTrace();
        } catch (JAXBException e) {
            System.out.println("JAXB-исключения");
            e.printStackTrace();
        }}}

