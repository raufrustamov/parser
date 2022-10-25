package parsers.dom;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public abstract class ElementNodeStream {

    public static Stream<Element> of(NodeList nodeList) {
        List<Element> nodes = new ArrayList<>(nodeList.getLength());
        NodeIterator nodeIterator = NodeIterator.from(nodeList);
        while (nodeIterator.hasNext()) {
            Node node = nodeIterator.next();
            if (node instanceof Element element) {
                nodes.add(element);
            }
        }
        return nodes.stream();
    }
}
