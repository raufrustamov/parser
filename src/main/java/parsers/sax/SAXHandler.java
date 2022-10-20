package parsers.sax;

import data.sax.SaxArticles;
import data.sax.SaxContacts;
import data.sax.SaxJournal;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SAXHandler extends DefaultHandler {

    SaxJournal journal;
    SaxArticles article;

    SaxContacts contacts;

    String content;


    int counter = 0;
    List<String> hotkeys;
    List<SaxArticles> articles;


    @Override
    public void startDocument() {

    }

    @Override
    public void endDocument() {

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        switch (qName) {
            case "journal" -> {
                counter = 1;
                journal = new SaxJournal();
            }
            case "contacts" -> {
                counter = 2;
                contacts = new SaxContacts();
            }
            case "articles" -> articles = new ArrayList<>();
            case "article" -> {
                counter = 3;
                article = new SaxArticles();
                article.setId(attributes.getValue("ID"));
            }
            case "hotkeys" -> hotkeys = new ArrayList<>();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        switch (qName) {
            case "journal":
                journal.setArticles(articles);
                journal.setContact(contacts);
                break;
            case "title":
                if (counter == 1) {
                    journal.setTitle(content);
                } else {
                    article.setTitle(content);
                }
                break;
            case "address":
                contacts.setAddress(content);
                break;
            case "tel":
                contacts.setTel(content);
                break;
            case "email":
                contacts.setEmail(content);
                break;
            case "url":
                if (counter == 2) {
                    contacts.setUrl(content);
                } else if (counter == 3) {
                    article.setUrl(content);
                }
                break;
            case "author":
                article.setAuthor(content);
                break;

            case "hotkey":
                hotkeys.add(content);
                article.setHotkeys(hotkeys);
                break;
            case "article":
                articles.add(article);
                break;

        }

    }

    @Override
    public void characters(char[] ch, int start, int length) {
        content = String.copyValueOf(ch, start, length).trim();

    }
}
