package Reachable;
import java.util.*;
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //Reading the number of node and the number of edges
        int numNodes = in.nextInt();
        int numEdges = in.nextInt();
        //Create an empty graph
        DirectedGraph2 g = new DirectedGraph2(numNodes);
        //Reading each edge and add it to the graph
        for(int i=0; i<numEdges; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            g.addEdge(u, v);
        }
        //List the nodes adjacent to each node
        for(int u=1; u<=g.nodeCount(); u++) {
            System.out.print("\n Nodes adjacent to " + u + " = ");
            for(int v : g.adjNodes(u))
                System.out.print(v + "  ");
        }

        //List each node which is adjacent to itself,
        //i.e. nodes with self loops.
        System.out.print("\n Nodes with self loops = ");
        for(int u=1; u<=g.nodeCount(); u++) {
            if(g.loopEdge(u,u))
                System.out.print(u + " ");
        } }
}