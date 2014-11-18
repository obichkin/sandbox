package com.obichkin;

/**
 * Created by mobichkin on 14/03/14.
 */
public class MySimpleThread {
    public static void main(String[] args) throws InterruptedException{
        int i=0;

        threadMessage("starting MyLoop !");

        Thread thread1 = new Thread(new MyLoop());
        thread1.start();

        threadMessage("waiting for MyLoop to finish...");

        while(thread1.isAlive()){
            i++;
            thread1.join(1000);
            threadMessage("still waiting ..");
            if(i>=9){
                threadMessage("Tired of waiting - lets terminate");
                thread1.interrupt();
                thread1.join();
            }
        }

        threadMessage("finally!!");
    }

    static void threadMessage(String message){
        String threadName = Thread.currentThread().getName();
        System.out.format("%s - %s\n", threadName, message);
    }

    static class MyLoop implements Runnable {
        @Override
        public void run() {
            String[] messages = {
                    "message number one",
                    "the second message",
                    "third and final",
                    "and more"
            };
            try{
                for(String s : messages){
                    Thread.sleep(4000);
                    threadMessage(s);
                }
            }catch (InterruptedException e){
                threadMessage("i was interrupted!");
            }
        }
    }
}
