package com.javarush.task.task33.task3309;

import java.io.IOException;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.sun.org.apache.xerces.internal.impl.PropertyManager;
import com.sun.xml.internal.stream.writers.XMLStreamWriterImpl;
import com.sun.xml.internal.txw2.output.IndentingXMLStreamWriter;



/* 
Комментарий внутри xml
*/

public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.FALSE);
        // самосериализация
        StringWriter writer = new StringWriter();
        XMLStreamWriter xmlStreamWriter =
                new IndentingXMLStreamWriter(
                        new XMLStreamWriterImpl(writer, new PropertyManager(PropertyManager.CONTEXT_READER))) {
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
                            writeComment(comment);
                        }
                    }
                };
        marshaller.marshal(obj, xmlStreamWriter);
        return writer.toString();
    }

    public static void main(String[] args) {

    }

}
