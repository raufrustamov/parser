package parsers.dom;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.Iterator;

public class NodeIterator implements Iterator<Node> {

    private final NodeList nodeList;

    private int currentIndex = 0;

    private NodeIterator(NodeList nodeList) {
        this.nodeList = nodeList;
    }

    public static NodeIterator from(NodeList nodeList) {
        if (nodeList == null) {
            throw new IllegalArgumentException();
        }

        return new NodeIterator(nodeList);
    }

    @Override
    public boolean hasNext() {
        return currentIndex < nodeList.getLength();
    }

    @Override
    public Node next() {
        return nodeList.item(currentIndex++);
    }
}
