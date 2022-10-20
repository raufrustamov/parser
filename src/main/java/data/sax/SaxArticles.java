package data.sax;

import java.util.List;
import java.util.Objects;

public class SaxArticles {

    private String title;
    private String author;
    private String url;
    private String id;
    private List<String> hotkeys;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getHotkeys() {
        return hotkeys;
    }

    public void setHotkeys(List<String> hotkeys) {
        this.hotkeys = hotkeys;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaxArticles that = (SaxArticles) o;
        return Objects.equals(title, that.title) && Objects.equals(author, that.author)
                && Objects.equals(url, that.url) && Objects.equals(id, that.id) && Objects.equals(hotkeys, that.hotkeys);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, url, id, hotkeys);
    }

    @Override
    public String toString() {
        return "SaxArticles{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", url='" + url + '\'' +
                ", id='" + id + '\'' +
                ", hotkeys=" + hotkeys +
                '}';
    }
}
