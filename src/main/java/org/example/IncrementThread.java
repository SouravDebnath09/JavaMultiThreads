package org.example;

public class IncrementThread extends Thread{
    public IncrementThread() {
    }
    @Override
    public void run() {
        int i =0;
        for(i=0;i<5;i++){
            System.out.println(i+" printed by thread name: "+Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        IncrementThread incrementThread = new IncrementThread();
        incrementThread.start();
    }
}


