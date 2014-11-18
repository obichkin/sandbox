package com.obichkin;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by mobichkin on 05/03/14.
 */
public class MyStack {
    public static void main(String[] args) {
        LinkedList<Integer> l = new LinkedList<Integer>(Arrays.asList( 1, 2, 3, 4, 5, 6));

        System.out.println(l.toString());


        System.out.println("pollFirst() " + l.pollFirst());

        System.out.println(l.toString());

        System.out.println("addFirst(10) " );
        l.addFirst(10);

        System.out.println(l.toString());

        System.out.println("addLast(11) " );
        l.addLast(11);

        System.out.println(l.toString());

        System.out.println("pollLast() " + l.pollLast());

        System.out.println(l.toString());


    }
}
