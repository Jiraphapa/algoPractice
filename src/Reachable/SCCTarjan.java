package Reachable;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Jrphapa on 3/27/2016 AD.
 */
public class SCCTarjan {
    DirectedGraph2 G;
    int[] low;
    int[] num;
    int[] state;

    int counter=1;
    int numSCC=0;

    Stack<Integer> stack;
    int[] onStack;

    public SCCTarjan(DirectedGraph2 g)
    {
        G=g;
        low=new int[G.nodeCount()];
        num=new int[G.nodeCount()];
        state=new int[G.nodeCount()];
        stack=new Stack<>();
        onStack=new int[G.nodeCount()];

        Arrays.fill(state,0);
        Arrays.fill(onStack,0);
        Arrays.fill(low,0);
        Arrays.fill(num,0);
    }
    public void scc()
    {
        for(int i=0;i<G.nodeCount();i++)
        {
            if(state[i]==0)
                dfsTarjan(i+1);
        }
    }


    public void dfsTarjan(int u)
    {
        state[u-1]=1;
        low[u-1]=num[u-1]=counter++;
        stack.push(u);
        onStack[u-1]=1;
        for(Integer v : G.GetContainer().get(u-1))
        {
            if(state[v-1]==0) //undiscover
            {
                dfsTarjan(v);
                low[u-1]=min(low[u-1],low[v-1]);
            }
            else if(state[v-1]==1) //discovered
            {
                low[u-1]=min(low[u-1],num[v-1]);
            }
            else if(state[v-1]==2) //explored
            {
                if(onStack[u-1]==1)
                    low[u-1]=min(low[u-1],num[v-1]);
            }
        }
        if(low[u-1]==num[u-1])
        {
            numSCC++;
            System.out.println("SCC #"+numSCC);
            while(true)
            {
                int v=stack.pop();
                onStack[v-1]=0;
                System.out.println("Node "+v);
                if(u==v)break;
            }
        }
        state[u-1]=2;
    }

    public int min(int a,int b)
    {
        if(a<b)return a;else return b;
    }
}
