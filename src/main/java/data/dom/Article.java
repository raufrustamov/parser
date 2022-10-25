package data.dom;

import java.util.List;

public class Article {
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
    public String toString() {
        return "Articles{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", url='" + url + '\'' +
                ", id='" + id + '\'' +
                ", hotkeys=" + hotkeys +
                '}';
    }
}

