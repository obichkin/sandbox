package com.obichkin;

import com.obichkin.MySimpleThread;

import static com.obichkin.MySimpleThread.threadMessage;

/**
 * Created by mobichkin on 17/03/14.
 */
public class MyConcurrentThread {
    static Counter c = new Counter();
    static final int INCREMENT_COUNT = 1000;

    public static void main(String[] args) throws InterruptedException {
        threadMessage("Start MyConcurrentCounter");

        Thread thread1 = new Thread(new CounterIncrement());
        Thread thread2 = new Thread(new CounterDecrement());

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        threadMessage("current value is " + c.getValue());
    }


}


class CounterIncrement implements Runnable {


    @Override
    public void run() {
        try {
            for(int i=0; i<=MyConcurrentThread.INCREMENT_COUNT; i++){
                MyConcurrentThread.c.increment(1);
                threadMessage("current value is " + MyConcurrentThread.c.getValue());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class CounterDecrement implements Runnable {
    @Override
    public void run() {
        try{
            for(int i=0; i<=MyConcurrentThread.INCREMENT_COUNT; i++){
                MyConcurrentThread.c.increment(-1);
                threadMessage("current value is " + MyConcurrentThread.c.getValue());
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Counter {
    private int counter=0;
    public /*synchronized*/ void increment(int i) throws InterruptedException {
        synchronized (this){
            int t = counter;
            Thread.sleep(1);
            t+=i;
            counter=t;
        }
    }
    /*public synchronized void decrement() throws InterruptedException {
        int t = counter;
        Thread.sleep(1);
        t++;
        counter=t;
    }*/
    public /*synchronized*/ int getValue(){
        synchronized (this){
            return counter;
        }
    }

}
