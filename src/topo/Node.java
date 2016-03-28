package topo;

import java.util.LinkedList;

/**
 * Created by Jrphapa on 3/27/2016 AD.
 */
public class Node {
    public String data;
    public int dist;
    public int inDegree;
    LinkedList<Node> AdjacenctNode = new LinkedList<Node>( );

    public void addAdjNode(final Node Child){
        AdjacenctNode.add(Child);
        Child.inDegree++;
    }

    public Node(String data) {
        super();
        this.data = data;
    }
}