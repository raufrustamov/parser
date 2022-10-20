package data.sax;

import java.util.List;
import java.util.Objects;

public class SaxJournal {
    String title;
    SaxContacts contact;
    List<SaxArticles> articles;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public SaxContacts getContact() {
        return contact;
    }

    public void setContact(SaxContacts contact) {
        this.contact = contact;
    }

    public List<SaxArticles> getArticles() {
        return articles;
    }

    public void setArticles(List<SaxArticles> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "SaxJournal{" +
                "title='" + title + '\'' +
                ", contact=" + contact +
                ", articles=" + articles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaxJournal that = (SaxJournal) o;
        return Objects.equals(title, that.title) && Objects.equals(contact, that.contact)
                && Objects.equals(articles, that.articles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, contact, articles);
    }
}
