package com.obichkin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by mobichkin on 20/02/14.
 */
public class MyHashCollections {
    public static void main(String[] args) {

        int n;
        int m;
        String s;
        final int ARRAY_SIZE = 1000000;
        Map<Dot, String> dotMap = new HashMap<Dot, String>();
        Random random = new Random();
        Dot d;

        //populate
        System.out.println("Populating:");
        while((n=random.nextInt(ARRAY_SIZE))!=1){
            m=random.nextInt(ARRAY_SIZE);
            s = String.valueOf(random.nextInt());
            dotMap.put(new Dot(m, n), s);
            System.out.println(m + " " + n + " " + s);
        }

        //search
        System.out.println("Searching:");
        while((n=random.nextInt(ARRAY_SIZE))!=1){
            m=random.nextInt(ARRAY_SIZE);

            s = dotMap.get(new Dot(m, n));
            if(s!=null){
                System.out.println(m + " " + n + " Value " + s);
            }else{
                System.out.println(m + " " + n + "NOt Found" );
            }

        }


    }
}



class Dot {
    int x;
    int y;

    @Override
    public boolean equals(Object o){
        if(o instanceof Dot){
            if(x==((Dot) o).getX() && y==((Dot) o).getY() ){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode(){
        return  x*y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }



}