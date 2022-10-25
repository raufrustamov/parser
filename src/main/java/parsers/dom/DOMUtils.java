package parsers.dom;

import data.dom.Article;
import data.dom.Contact;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;


public class DOMUtils {

    private static final Map<String, BiConsumer<Contact, String>> contactsSetters = Map.of(
            "address", Contact::setAddress,
            "tel", Contact::setTel,
            "email", Contact::setEmail,
            "url", Contact::setUrl
    );

    private static final Map<String, BiConsumer<Article, Element>> articlesSetters = Map.of(
            "title", (article, element) -> article.setTitle(element.getTextContent()),
            "author", (article, element) -> article.setAuthor(element.getTextContent()),
            "url", (article, element) -> article.setUrl(element.getTextContent()),
            "hotkeys", DOMUtils::setArticlesHotkeys
    );

    public static Document getDocument(String pathToXml) throws SAXException, IOException, ParserConfigurationException {
        return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(pathToXml);
    }

    public static Contact getContacts(Node contactsNode) {
        Contact contact = new Contact();
        ElementNodeStream.of(contactsNode.getChildNodes())
                .forEach(element -> setContactsField(contact, element));
        return contact;
    }

    private static void setContactsField(Contact contact, Element element) {
        contactsSetters.getOrDefault(element.getNodeName(), (c, e) -> {})
                .accept(contact, element.getTextContent());
    }

    public static List<Article> getArticles(Node articles) {
        return ElementNodeStream.of(articles.getChildNodes())
                .filter(element -> element.getNodeName().equals("article"))
                .map(DOMUtils::buildArticle)
                .toList();
    }

    private static Article buildArticle(Element articlesChildElements) {
        Article article = new Article();
        article.setId(articlesChildElements.getAttributes().getNamedItem("ID").getTextContent());

        ElementNodeStream.of(articlesChildElements.getChildNodes())
                .forEach(element -> setArticlesField(article, element));

        return article;
    }

    private static void setArticlesField(Article article, Element element) {
        articlesSetters.getOrDefault(element.getNodeName(), (a, e) -> {})
                .accept(article, element);
    }

    private static void setArticlesHotkeys(Article article, Element element) {
        NodeList hotkeysChildElement = element.getChildNodes();

        List<String> hotkeys = ElementNodeStream.of(hotkeysChildElement)
                .map(Node::getTextContent)
                .toList();

        article.setHotkeys(hotkeys);
    }
}




