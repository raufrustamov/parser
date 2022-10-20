package data.dom;

import java.util.List;

public class Journal {

    private String title;
    private Contacts contacts;
    private List<Articles> articles;

    public List<Articles> getArticles() {
        return articles;
    }

    public void setArticles(List<Articles> articles) {
        this.articles = articles;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }


    public String getTitle() {
        return title;
    }

    public Contacts getContacts() {
        return contacts;
    }


    @Override
    public String toString() {
        return "Journal{" +
                "title='" + title + '\'' +
                ", contacts=" + contacts +
                ", articles=" + articles +
                '}';
    }


}
