package data.dom;

import java.util.List;

public class Journal {

    private String title;
    private Contact contact;
    private List<Article> articles;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "title='" + title + '\'' +
                ", contacts=" + contact +
                ", articles=" + articles +
                '}';
    }


}
