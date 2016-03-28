package Reachable;

import java.util.Scanner;

/**
 * Created by Jrphapa on 3/27/2016 AD.
 */
public class dagCheck {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("n= ");
        int numNodes = in.nextInt();
        System.out.println("Edges :");
        int u;
        int v;
        DirectedGraph2 g = new DirectedGraph2(numNodes);
        while(true)
        {
            u = in.nextInt();
            v = in.nextInt();
            if(u==0 && v==0)
                break;
            g.addEdge(u, v);
        }

        g.topo();
        System.out.println();

    }

}
