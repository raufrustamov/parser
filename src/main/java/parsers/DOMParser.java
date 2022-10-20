package parsers;

import data.dom.Articles;
import data.dom.Journal;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class DOMParser {
    private static final String XML_DOC_PATH = "testfile.xml";

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        Journal journal = new Journal();
        Document document = DOMUtils.getDocument(XML_DOC_PATH);
        Node rootNode = document.getFirstChild();


        NodeList rootChild = rootNode.getChildNodes();
        String mainTitle = null;
        Node contacts = null;
        Node articles = null;
        for (int i = 0; i < rootChild.getLength(); i++) {
            if (rootChild.item(i) instanceof Element) {
                switch (rootChild.item(i).getNodeName()) {
                    case "title":
                        mainTitle = rootChild.item(i).getTextContent();
                    case "contacts":
                        contacts = rootChild.item(i);

                    case "articles":
                        articles = rootChild.item(i);

                }
            }
        }
        journal.setTitle(mainTitle);
        journal.setContacts(DOMUtils.getContacts(contacts));
        List<Articles> articleList = DOMUtils.getArticles(articles);
        journal.setArticles(articleList);
        System.out.println(journal);
    }


}








