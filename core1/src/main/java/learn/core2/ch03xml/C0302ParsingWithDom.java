package learn.core2.ch03xml;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class C0302ParsingWithDom {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        File file = new File("io-data/xml/font.xml");
        Document doc = builder.parse(file);
        Element root = doc.getDocumentElement();
        NodeList children = root.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            System.out.printf("child %d%n", i);
            if (child instanceof Element) {
                Element childElement = (Element) child;
                Text textNode = (Text) childElement.getFirstChild();
                String text = textNode.getData().trim();
                if (childElement.getTagName().equals("name")) {
                    System.out.printf("name = %s%n", text);
                } else if (childElement.getTagName().equals("size")) {
                    System.out.printf("size = %s%n", text);
                }
            }
        }
    }
}
