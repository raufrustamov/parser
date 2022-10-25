package parsers.dom;

import data.dom.Journal;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.logging.Logger;

public class DOMParser {

    private static final Logger log = Logger.getLogger(DOMParser.class.getName());

    private final String xmlFileName;

    private final Map<String, BiConsumer<Journal, Element>> journalSetters = Map.of(
            "title", (journal, element) -> journal.setTitle(element.getTextContent()),
            "contacts", (journal, element) -> journal.setContact(DOMUtils.getContacts(element)),
            "articles", (journal, element) -> journal.setArticles(DOMUtils.getArticles(element))
    );

    public DOMParser(String xmlFileName) {
        this.xmlFileName = xmlFileName;
    }

    public Journal parseJournal() throws IOException, ParserConfigurationException, SAXException {
        Document document = DOMUtils.getDocument(xmlFileName);
        Node rootNode = document.getFirstChild();

        Journal journal = new Journal();
        ElementNodeStream.of(rootNode.getChildNodes())
                .forEach(element -> setFieldToJournal(journal, element));

        return journal;
    }

    private void setFieldToJournal(Journal journal, Element element) {
        journalSetters.getOrDefault(element.getNodeName(), (j, n) -> {})
                .accept(journal, element);
    }

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DOMParser journalParser = new DOMParser("testfile.xml");
        Journal journal = journalParser.parseJournal();
        log.info("Result: " + journal);
    }
}








