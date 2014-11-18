package com.obichkin.algorythms1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by mobichkin on 27.10.14.
 */
public class Question2 {
    private int[] integerArray = new int[10000];
    private static long count=0;

    private void readArray() throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader("QuickSort.txt"));
        for(int i=0; i<integerArray.length; i++){
            integerArray[i] = Integer.parseInt(reader.readLine());
        }
    }

    private void writeArray(){
        for(int i=0; i<integerArray.length; i++){
            System.out.println(integerArray[i]);
        }
    }


    enum Pivot {
        FIRST, LAST, MEDIAN
    }


    private void quickSort(int[] a, int l, int r, Pivot pivot){
        if(l<r){
            count= count+r-l;
            int t; //temporary int for swaps
            int p=0; //pivot index
            int m=0; //median index
            switch (pivot){
                case FIRST:
                    p = a[l];
                    break;
                case LAST:
                    p=a[r];
                    t=a[l]; a[l]=a[r]; a[r]=t;   //swap
                    break;
                case MEDIAN:
                    m=(r+l)/2; //median

                    if( a[l]<=a[m] && a[m]<=a[r]){

                        t=a[l]; a[l]=a[m]; a[m]=t;   //swap
                        p=a[l];
                    }else if(a[m]<=a[l] && a[l]<=a[r]){
                        p=a[l];
                    }else{

                        t=a[l]; a[l]=a[r]; a[r]=t;  //swap
                        p=a[l];
                    }
                    break;

            }

            int i=l+1;
            for(int j=l+1; j<=r; j++){
                if(a[j]<p){
                    t=a[i]; a[i]=a[j]; a[j]=t;  //swap
                    i++;
                }
            }
            t=a[l]; a[l]=a[i-1]; a[i-1]=t; //swap

            quickSort(a, l, i-2, pivot);
            quickSort(a, i, r, pivot);

        }
    }




    public static void main(String[] args) throws IOException {
        System.out.println("This is Question2.");

        Question2 question2 = new Question2();
        question2.readArray();

        //question2.integerArray = new int[]{2,5,6,3,4,1,8,9,7};



        question2.quickSort(question2.integerArray, 0, question2.integerArray.length-1, Pivot.MEDIAN);
        System.out.println("Pivot.MEDIAN count: " + count);



        //question2.quickSort(question2.integerArray, 0, question2.integerArray.length-1, Pivot.LAST);
        //System.out.println("Pivot.LAST count: " + count);



        //question2.quickSort(question2.integerArray, 0, question2.integerArray.length-1, Pivot.FIRST);
        //System.out.println("Pivot.FIRST count: " + count);






        //question2.writeArray();


    }

}
