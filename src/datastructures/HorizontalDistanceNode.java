package datastructures;

public class HorizontalDistanceNode {
    Node node;
    int hd;

    public HorizontalDistanceNode(Node node, int hd) {
        this.hd = hd;
        this.node = node;
    }

    public Node getNode() {
        return node;
    }

    public int getHd() {
        return hd;
    }
}
