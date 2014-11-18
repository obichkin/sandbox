package com.obichkin;

/**
 * Created by mobichkin on 13/03/14.
 */
public class MyThread implements Runnable {
    @Override
    public void run(){
        System.out.println("Hello Thread!");
    }

    public static void main(String[] args) throws InterruptedException{
        try{
            Thread thread = new Thread(new MyThread());

            Thread.sleep(2000);
            thread.start();

            if(Thread.interrupted()){
                throw new InterruptedException("We have been interrupted!");
            }
            thread.interrupt();
        }catch(InterruptedException e){
            e.printStackTrace();
            System.out.println("catch Interrupted Exception");
        }
    }
}
