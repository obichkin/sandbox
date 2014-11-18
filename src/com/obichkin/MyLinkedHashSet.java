package com.obichkin;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by mobichkin on 21/02/14.
 */
public class MyLinkedHashSet {
    public static void main(String[] args) {
        Set<MyItem> mySet = new LinkedHashSet<MyItem>();
        mySet.add(new MyItem("123", "asd"));
        mySet.add(new MyItem("567", "cvb"));
        mySet.add(new MyItem("981", "uyt"));
        mySet.add(new MyItem("981", "uyt"));
        mySet.add(new MyItem("981", "uyt"));
        mySet.add(new MyItem("981", "uyt"));
        System.out.println("mySet.size : " + mySet.size());
        System.out.println("contains 981, uyt : " + mySet.contains(new MyItem("981", "uyt")));
        for(MyItem i : mySet){
            System.out.println(i.hashCode());
        }
    }
}


class MyItem {
    MyItem(String item1, String item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    String item1;
    String item2;

    public String getItem1() {
        return item1;
    }

    public void setItem1(String item1) {
        this.item1 = item1;
    }

    public String getItem2() {
        return item2;
    }

    public void setItem2(String item2) {
        this.item2 = item2;
    }

    @Override
    public int hashCode(){
        return item1.hashCode() + item2.hashCode();
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof MyItem){
            return item1.equals(((MyItem) o).getItem1()) && item2.equals(((MyItem) o).getItem2());
        }
        return false;
    }
}