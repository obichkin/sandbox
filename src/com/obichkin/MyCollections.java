package com.obichkin;

import java.io.*;
import java.util.*;

/**
 * Created by mobichkin on 18/02/14.
 */
public class MyCollections {
    public static void main(String[] args) throws IOException{
        //treeSet();
        list();
    }


    static void list(){
        ArrayList<Adj> arrayList = new ArrayList<Adj>();
        String s;
        String[] ss;

        try{
            BufferedReader reader = new BufferedReader(new FileReader("./input.txt"));
            while((s = reader.readLine()) != null){
                ss = s.split(";");
                arrayList.add(new Adj(ss[0], ss[1]));
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        Collections.sort(arrayList);

        int i = Collections.binarySearch(arrayList, new Adj("126", ""));
        /*
        int i = Collections.binarySearch(arrayList, new Adj("126", ""), new Comparator<Adj>() {
            @Override
            public int compare(Adj o1, Adj o2) {
                return o1.compareTo(o2);
            }
        });
        */
        System.out.println("Found Adj : " + arrayList.get(i).getAdj_id());

        for(Adj a:arrayList){
            System.out.println(a.getAdj_id() + " " + a.getStatus());
        }
    }


    static void treeSet() {
        TreeSet<Adj> treeSet = new TreeSet<Adj>();
        TreeMap<String, String> treeMap = new TreeMap<String, String>();

        String s;
        String[] ss;


        try{
            BufferedReader reader = new BufferedReader(new FileReader("./input.txt"));
            while((s = reader.readLine()) != null){
                ss = s.split(";");
                treeSet.add(new Adj(ss[0], ss[1]));
                treeMap.put(ss[0], ss[1]);
                //System.out.println(ss[0] + " : " + ss[1]);
            }

        }catch (IOException e){
            e.printStackTrace();
        }

        /*        for(Adj a : treeSet){
                    System.out.println(a.getAdj_id() + " " + a.getStatus());
        }  */

        for(String s3 : treeMap.keySet()){
            System.out.println(s3 + " : " + treeMap.get(s3));
        }

    }

}


class Adj implements Comparable<Adj>{
    private String adj_id;
    private String status;

    public String getAdj_id() {
        return adj_id;
    }

    public void setAdj_id(String adj_id) {
        this.adj_id = adj_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Adj(String adj_id, String status) {
        this.adj_id = adj_id;
        this.status = status;
    }

    @Override
    public int compareTo(Adj o) {
        return -adj_id.compareTo(o.adj_id);
    }
}
