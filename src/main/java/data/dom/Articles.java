package data.dom;

import org.w3c.dom.NamedNodeMap;

import java.util.List;

public class Articles {
    private String title;

    private String author;
    private String url;
    private String id;
    private List<String> hotkeys;

    public List<String> getHotkeys() {
        return hotkeys;
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

    public Articles(String title, String author, String url, String id, List<String> hotkeys) {
        this.title = title;
        this.author = author;
        this.url = url;
        this.id = id;
        this.hotkeys = hotkeys;
    }
}

