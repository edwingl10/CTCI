package TreesAndGraphs;
import java.util.ArrayList;

// used for graph
public class Node {
    public String name;
    ArrayList<Node> children;
    State state;

    Node(String name){
        this.name= name;
        this.children = new ArrayList<Node>();
    }

    // returns nodes it points to
    ArrayList<Node> getAdjacent(){
        return children;
    }

    void addChild(Node n){
        children.add(n);
    }

}
