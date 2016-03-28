package Reachable;

import java.util.Scanner;

/**
 * Created by Jrphapa on 3/26/2016 AD.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //Reading the number of node and the number of edges
        int numNodes = in.nextInt();
        int numEdges = in.nextInt();
        int StartNode =in.nextInt();
        //Create an empty graph
        DirectedGraph2 g = new DirectedGraph2(numNodes);
        //Reading each edge and add it to the graph
        for(int i=0; i<numEdges; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            g.addEdge(u, v);
        }

//        if(g.edge(3,1) && g.edge(1,3))
//            System.out.print("yes");
        for(int i=0;i<numNodes;i++)
        {
            if(g.edge(StartNode,i+1) && g.edge(i+1,StartNode))
            {
                System.out.print(i+1+" ");
            }
        }



    }
}
