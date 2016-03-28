package Reachable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Jrphapa on 3/26/2016 AD.
 */
public class DirectedGraph2 {
    DirectedGraph2(int n)
    {
        NodeCount=n;
        group = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++) {
            group.add(new ArrayList<Integer>());
            //System.out.println(group.get(i));
        }
    }

    public int nodeCount()
    {
        return NodeCount;
    }
    public int edgeCount() {
        //Your code here
        return EdgeCount;
    }
    //Add a directed edge from u to v to graph
    public void addEdge(int u, int v) {
        //Your code here
        EdgeCount++;
        ArrayList<Integer> temp=group.get(u-1);
        temp.add(v);
        group.set(u-1,temp);
    }
    public int[] adjNodes(int u) {
        //Your code here
        int[] fin=new int[group.get(u-1).size()];
        //System.out.println(group.get(u-1).size());
        for(int i = 0; i < group.get(u-1).size(); i++) {
            if (group.get(u-1).get(i) != null ) {
                fin[i] = group.get(u-1).get(i);
            }
        }
        return fin;
    }
    public void topo()
    {
        //boolean isDag=true;
        for(int m=0;m<NodeCount;m++)
        {
            if(edge(m+1,m+1))
            {
                //isDag=false;
                System.out.println("Not a Dag!");
                return;
            }

        }
        System.out.println("A topological ordering is ");
        ArrayList<Integer> box=new ArrayList<>();
        ArrayList<Integer> poplist=new ArrayList<>();
        for(ArrayList<Integer> list:group)
        {
            for(Integer num: list)
            {
                box.add(num);
            }
        }
        while(!box.isEmpty()) {
            for (int k = 1; k < nodeCount() + 1; k++) {

                if (!box.contains(k) && !poplist.contains(k)) //no incoming edge and not already printed
                {
                    System.out.println(k + " ");
                    poplist.add(k);
                    //remove that k point to
                    for (Integer item : group.get(k - 1)) {
                        if (box.contains(item))
                            box.remove(item);
                    }
                }
            }
        }
        System.out.println();
    }
    public ArrayList<ArrayList<Integer>> GetContainer()
    {
        return group;
    }
    public boolean loopEdge(int u,int v)
    {
        if(u!=v)
            return false;
        else
        {
            int[] list=adjNodes(u);
            for(int i=0;i<list.length;i++)
            {
                if(list[i]==v)
                    return true;
            }
            return false;
        }
    }
    public boolean edge(int u, int v) {
        if(u==v){
            int[] list=adjNodes(u);
            for(int i=0;i<list.length;i++)
            {
                if(list[i]==v)
                    return true;
            }

        }
        stack.push(u);
        int[] state=new int[NodeCount];
        Arrays.fill(state,0);

        //already visited in the first time
//        for (int i = 0; i < group.get(u-1).size(); i++) {
//            stack.push(group.get(u-1).get(i));
//            state[group.get(u-1).get(i)] = 1;
//        }
        while(!stack.isEmpty())
        {
            u=stack.pop();
            if(u!=v)
                state[u-1]=1;

            for(Integer mem : group.get(u-1)) {
                if (state[mem- 1] == 0) {
                    state[mem - 1] = 1;

                    stack.push(mem);
                }
            }

            if(stack.contains(v)) {
                stack=new Stack<>();
                return true;
            }

        }
        stack=new Stack<>();
        return false;

    }

    Stack<Integer> stack=new Stack<>();
    private ArrayList<ArrayList<Integer>> group;
    private int EdgeCount=0;
    private int NodeCount=0;

}
