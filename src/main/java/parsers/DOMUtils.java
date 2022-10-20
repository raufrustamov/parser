package parsers;
import data.dom.Articles;
import data.dom.Contacts;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DOMUtils {
    public static Document getDocument(String pathToXml) throws SAXException, IOException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document document = factory.newDocumentBuilder().parse(pathToXml);
        return document;
    }

    public static Contacts getContacts(Node contacts) {
        Contacts setContacts = new Contacts();
        NodeList contactsChildElements = contacts.getChildNodes();
        for (int i = 0; i < contactsChildElements.getLength(); i++) {
            if (contactsChildElements.item(i) instanceof Element) {

                switch (contactsChildElements.item(i).getNodeName()) {
                    case "address":
                        setContacts.setAddress(contactsChildElements.item(i).getTextContent());
                    case "tel":
                        setContacts.setTel(contactsChildElements.item(i).getTextContent());
                    case "email":
                        setContacts.setEmail(contactsChildElements.item(i).getTextContent());
                    case "url":
                        setContacts.setUrl(contactsChildElements.item(i).getTextContent());
                }
            }

        }
        return setContacts;
    }

    public static List<Articles> getArticles(Node articles) {
        List<Articles> articleList = new ArrayList<>();
        NodeList articlesChildElements = articles.getChildNodes();
        String id = "";


        for (int i = 0; i < articlesChildElements.getLength(); i++) {
            if (!articlesChildElements.item(i).getNodeName().equals("article")) {
                continue;
            }
            if (articlesChildElements.item(i) instanceof Element) {
                NodeList elementsOfChildArticles = articlesChildElements.item(i).getChildNodes();
                String title = "";
                String author = "";
                String url = "";
                List<String> hotkeys = new ArrayList<>();
                id = articlesChildElements.item(i).getAttributes().getNamedItem("ID").getTextContent();


                for (int j = 0; j < elementsOfChildArticles.getLength(); j++) {

                    if (elementsOfChildArticles.item(j) instanceof Element) {
                        switch (elementsOfChildArticles.item(j).getNodeName()) {
                            case "title":
                                title = elementsOfChildArticles.item(j).getTextContent();
                            case "author":
                                author = elementsOfChildArticles.item(j).getTextContent();
                            case "url":
                                url = elementsOfChildArticles.item(j).getTextContent();
                            case "hotkeys":
                                NodeList hotkeysChildElement = elementsOfChildArticles.item(j).getChildNodes();

                                for (int a = 0; a < hotkeysChildElement.getLength(); a++) {
                                    if (hotkeysChildElement.item(a) instanceof Element) {
                                        hotkeys.add(hotkeysChildElement.item(a).getTextContent());
                                    }
                                }

                        }
                    }
                }
                Articles newArticle = new Articles(title, author, url, id, hotkeys);
                articleList.add(newArticle);
            }
        }
        return articleList;
    }


}




