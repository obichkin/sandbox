package com.obichkin.algorythms1;

import java.io.*;
import java.sql.Time;

/**
 * Created by mobichkin on 15.10.14.
 */
public class Question1 {
    private int[] integerArray = new int[100000];
    private long count =0;

    private void readArray() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("IntegerArray.txt"));
        for(int i=0; i<integerArray.length; i++)
            integerArray[i] = Integer.parseInt(bufferedReader.readLine());
    }

    private void writeArray(int[] a){
        for(int i=0; i<a.length; i++)
            System.out.println(a[i] + ", ");
        System.out.println();
    }

    private void countDuplicates(){
        int c=0;
        for(int i=0; i<integerArray.length; i++){
            for(int j=i+1; j<integerArray.length; j++){
                if (integerArray[i]==integerArray[j]){
                    c++;
                    System.out.println("Duplicate found " + integerArray[i]);
                }
            }
        }
        System.out.println("Duplicate counts: " + c);
    }


    private void countInversions(int[] a){
        long time1 = System.currentTimeMillis();
        long c=0;
        for(int i=0; i<a.length; i++){
            for(int j=i+1; j<a.length; j++){
                if (a[i]>a[j]){
                    c++;
                    //if(c%1000000==0)
                      //  System.out.println("Inversion found " + integerArray[i] + " > " + integerArray[j]);

                }
            }
        }
        time1 = System.currentTimeMillis() - time1;
        System.out.println("Inversions counts: " + c + " Running time: " + time1 + " milli seconds");
    }

    private void countInversions2(int[] a){
        long time1 = System.currentTimeMillis();
        count =0;
        a = sortArray(a);
        time1 = System.currentTimeMillis() - time1;
        System.out.println("Inversions counts: " + count + " Running time: " + time1 + " milli seconds");
    }



    private int[] sortArray(int[] c){
        if(c.length>1){
            int l = Math.round(c.length/2);
            int[] a = new int[l];
            int[] b = new int[c.length-l];

            System.arraycopy(c, 0, a, 0,l);
            System.arraycopy(c, l, b, 0, c.length-l);

            //System.out.println("array a ");            writeArray(a);
            //System.out.println("array b ");            writeArray(b);

            //a = sortArray(a);
            //b = sortArray(b);

            c = mergeArrays(sortArray(a),  sortArray(b));
        }


        return c;
    }


    private int[] mergeArrays(int[] a, int[] b){
        int c[] = new int[a.length+b.length];

        int i=0;
        int j=0;

        for(int k=0; k<c.length; k++){

            if((j>=b.length && i<a.length) ){
                c[k]=a[i];
                i++;
            }else if((i>=a.length && j<b.length) ) {
                c[k] = b[j];
                count+=(a.length-i);
                j++;
            }else if(b[j]<a[i]){
                c[k] = b[j];
                count+=(a.length-i);
                j++;
            }else if (a[i]<b[j]){
                c[k]=a[i];
                i++;
            }


        }

        return c;
    }



    public static void main(String[] args) throws IOException {
        System.out.println("This is question 1. Inversion counts");

        Question1 question1 = new Question1();
        question1.readArray();
        //question1.integerArray = new int[]{4,3,2,1};

        //question1.writeArray(integerArray);

        //question1.countDuplicates();
        question1.countInversions(question1.integerArray);
        //Inversions counts: 2407905288


        question1.countInversions2(question1.integerArray);

           }

}
