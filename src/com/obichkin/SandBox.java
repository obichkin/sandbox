package com.obichkin;



/**
 * Created by mobichkin on 12/02/14.
 */
public class SandBox implements Cloneable {
    public static void main(String[] args) throws Throwable {
        SandBox sandBox = new SandBox();
        SandBox sandBox1 = (SandBox) sandBox.clone();
        //SandBox sandBox1 = sandBox;
        //SandBox sandBox1 = new SandBox();

        Boolean b = (sandBox==sandBox1);
        System.out.println("sandBox==sandBox1 : " + b );


        Integer x = 1;
        Integer y = 1;


        System.out.println("x.equals(y) : " + x.equals(y));
        b = (x==y);
        System.out.println("x==y : " + b);


        Integer z = 5;
        if((z!=0) && (5/z==1) ){
            System.out.println(z + " (z!=0) && (5/z==1)");
        } else {
            System.out.println(z + " passed through deletion on zero.");
        }

    }
}
