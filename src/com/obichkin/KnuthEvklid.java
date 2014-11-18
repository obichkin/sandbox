package com.obichkin;

/**
 * Created by mobichkin on 13/02/14.
 */
public class KnuthEvklid {
    public static void main(String[] args) {
        int m = 2166;
        int n = 6099;
        KnuthEvklid k = new KnuthEvklid();
        System.out.println(m + "%" + n + " = " + m % n);
        System.out.println("minimalDenominator of " + m + " and " + n + " is " + k.minimalDenominator(m, n));
    }

    int minimalDenominator(int m, int n){
        int r;
        while(true){
            r = m%n;
            System.out.println(m + "%" + n + " = " + m % n);
            if (r==0) {
                return n;
            }else{
                m = n;
                n = r;
            }
        }
    }
}
