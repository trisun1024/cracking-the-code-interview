import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class RouteBetweenNodes {

    // Given a directed graph and two nodes (S and E), design an algorithm to find out whether there is a
    // route from S to E

    public boolean searchBFS(Graph g, Node s, Node e) {
        return false;
    }

    static class Node {
        public String name;
        public Node[] children;
    }

    static class Graph {
       public Node[] nodes;
    }
}
