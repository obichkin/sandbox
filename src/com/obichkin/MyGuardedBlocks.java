package com.obichkin;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import static java.lang.System.out;

/**
 * Created by mobichkin on 18/03/14.
 */
public class MyGuardedBlocks {

    public static String message = "";

    public static void main(String[] args) {
        Drop drop = new Drop();

        ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

        //rwl.readLock().lock();
        if(rwl.isWriteLocked()){
            rwl.writeLock().unlock();
        }




        //(new Thread(new Producer(drop))).start();
        //(new Thread(new Consumer(drop))).start();

        (new Thread(new Producer(rwl))).start();
        (new Thread(new Consumer(rwl))).start();

    }
}


class Consumer implements Runnable {
    private Drop drop;
    private ReentrantReadWriteLock rwl;
    String s="";
    Random random = new Random();

    public Consumer(Drop drop) {
        this.drop = drop;
    }

    public Consumer(ReentrantReadWriteLock rwl) {
        this.rwl = rwl;
    }

    @Override
    public void run() {
        do{
            try {
                //s = drop.getMessage();
                out.format("Consumer. berfore readLock.lock()%n");
                //rwl.readLock().lock();
                out.format("Consumer. after readLock.lock()%n");

                if(!MyGuardedBlocks.message.isEmpty()){
                    s = MyGuardedBlocks.message;
                    System.out.format("message recieved : %s%n", s);
                    if(rwl.isWriteLocked()){
                        rwl.writeLock().unlock();
                    }
                }
                Thread.sleep(random.nextInt(2000));

            } catch (InterruptedException e) {}
        }
        while (!s.equals("THE END!"));
    }
}




class Producer implements Runnable {
    private Drop drop;
    private ReentrantReadWriteLock rwl;
    Random random = new Random();

    public Producer(Drop drop) {
        this.drop = drop;
    }

    Producer(ReentrantReadWriteLock rwl) {
        this.rwl = rwl;
    }

    @Override
    public void run() {
        String messages[] = {
                "message 1",
                "message 2",
                "third message",
                "4eTblpE message",
                "THE END!"
        };

        for(int i=0; i<messages.length; i++){
            try {
                //drop.setMessage(messages[i]);

                    out.format("Producer. before writeLock.tryLock()%n");
                    rwl.writeLock().lock();
                    out.format("Producer. after writeLock.tryLock()%n");
                    MyGuardedBlocks.message = messages[i];

                    //rwl.readLock().unlock();


                    Thread.sleep(random.nextInt(5000));


            } catch (InterruptedException e) {}
        }

        //drop.setMessage("THE END!");
    }
}


class Drop{

    private String message;
    private boolean empty = true;

    public synchronized String getMessage() {
        while(empty){
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        empty = true;
        notifyAll();
        return message;
    }

    public synchronized void setMessage(String message) {
        while(!empty){
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        this.message = message;
        empty = false;
        notifyAll();

    }
}