package com.javarush.task.task33.task3309;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.sun.xml.internal.txw2.output.IndentingXMLStreamWriter;



/* 
Комментарий внутри xml
*/

public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException, XMLStreamException {
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        // самосериализация
        XMLOutputFactory writerfactory = XMLOutputFactory.newInstance();
        OutputStream os = new ByteArrayOutputStream();
        XMLStreamWriter xsw = writerfactory.createXMLStreamWriter(os);
        XMLStreamWriter xmlStreamWriter =
                new IndentingXMLStreamWriter(xsw) {
                    @Override
                    public void writeStartElement(String localName) throws XMLStreamException {
                        insertCommentIfNeeded(localName);
                        super.writeStartElement(localName);
                    }

                    @Override
                    public void writeStartElement(String namespaceURI, String localName) throws XMLStreamException {
                        insertCommentIfNeeded(localName);
                        super.writeStartElement(namespaceURI, localName);
                    }

                    @Override
                    public void writeStartElement(String prefix, String localName, String namespaceURI) throws XMLStreamException {
                        insertCommentIfNeeded(localName);
                        super.writeStartElement(prefix, localName, namespaceURI);
                    }

                    @Override
                    public void writeEmptyElement(String namespaceURI, String localName) throws XMLStreamException {
                        insertCommentIfNeeded(localName);
                        super.writeEmptyElement(namespaceURI, localName);
                    }

                    @Override
                    public void writeEmptyElement(String prefix, String localName, String namespaceURI) throws XMLStreamException {
                        insertCommentIfNeeded(localName);
                        super.writeEmptyElement(prefix, localName, namespaceURI);
                    }

                    @Override
                    public void writeEmptyElement(String localName) throws XMLStreamException {
                        insertCommentIfNeeded(localName);
                        super.writeEmptyElement(localName);
                    }

                    private void insertCommentIfNeeded(String localName) throws XMLStreamException {
                        if (tagName.equalsIgnoreCase(localName)) {
                            writeCharacters(System.lineSeparator());
                            writeComment(comment);
                        }
                    }
                };
        marshaller.marshal(obj, xmlStreamWriter);
        return os.toString();
    }

    public static void main(String[] args) throws Exception {
        AnExample obj = new AnExample();
        System.out.println(toXmlWithComment(obj, "needCDATA", "comment"));
    }

    @XmlType(name = "anExample")
    @XmlRootElement
    public static class AnExample {
        @XmlElement(name = "needCDATA", type = String.class)
        public String[] needCDATA = new String[]{"<needCDATA><![CDATA[need CDATA because of < <>& and >]]></needCDATA>", ""};

        public List<String> characters = new ArrayList<>();
    }

}
