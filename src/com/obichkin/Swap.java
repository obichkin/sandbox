package com.obichkin;

/**
 * Created by mobichkin on 28.10.14.
 */
public class Swap {
    public static void main(String[] args) {

        int t;
        int[] a=new int[]{7,6,5,8,4,9,2,3};


        System.out.println(a.toString());
        t=a[0]; a[0]=a[7]; a[7]=t;

        System.out.println(a.toString());

    }


}
