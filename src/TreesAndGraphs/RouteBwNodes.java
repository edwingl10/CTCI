package TreesAndGraphs;
import java.util.LinkedList;
import java.util.Queue;

public class RouteBwNodes {
    /**
     * Given a directed graph, design an algorithm to find out whether there is a
     * route between two nodes.
     */
    static boolean search(Graph g, Node start, Node end){
        if(start == end) return true;
        Queue<Node> q = new LinkedList<Node>();

        for(Node n: g.getNodes()){
            n.state = State.Unvisited;
        }

        start.state = State.Visiting;
        q.add(start);
        Node u;
        while(!q.isEmpty()){
            u = q.poll();
            if(u != null){
                for(Node v: u.getAdjacent()){
                    if(v.state == State.Unvisited){
                        if(v == end) return true;
                        else{
                            v.state = State.Visiting;
                            q.add(v);
                        }
                    }
                }
                u.state = State.Visited;
            }
        }

        return false;
    }

    public static void main(String[] args){
        Node node1 = new Node("a");
        Node node2 = new Node("b");
        Node node3 = new Node("c");
        Node node4 = new Node("d");
        Node node5 = new Node("e");

        node1.addChild(node2);
        node2.addChild(node3);
        node2.addChild(node4);
        node4.addChild(node5);


        Node[] n = {node1, node2, node3, node4, node5};


        Graph g = new Graph(n);
        System.out.println(search(g, node1, node5));
    }

}
