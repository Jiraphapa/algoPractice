package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by Jrphapa on 3/26/2016 AD.
 */
public class test {
    public static void main(String[] args){
        PriorityQueue<Integer> pp=new PriorityQueue<>();
        pp.add(1);
        pp.add(9);
        System.out.println(pp.peek());
        System.out.println(pp.toString());
        pp.add(2);
        pp.add(3);
        System.out.println(pp.toString());

        pp.poll();
        System.out.println(pp.toString());
        pp.remove();
        System.out.println(pp.toString());

    }
}

