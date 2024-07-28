package org.example;

public class PrintTrio {

    private volatile String sequence="ONE";
    synchronized void printOne(int number){
        while(sequence!="ONE"){
            try{
                wait();
            }
            catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }

        System.out.println(Thread.currentThread().getName()+" print number: "+number);
        sequence="TWO";
        notifyAll();
    }
    synchronized void printTwo(int number){
        while(sequence!="TWO"){
            try{
                wait();
            }
            catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }

        System.out.println(Thread.currentThread().getName()+" print number: "+number);
        sequence="THREE";
        notifyAll();
    }
    synchronized void printThree(int number){
        while(sequence!="THREE"){
            try{
                wait();
            }
            catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }

        System.out.println(Thread.currentThread().getName()+" print number: "+number);
        sequence="ONE";
        notifyAll();
    }
    public static void main(String[] args) {
        PrintTrio printTrio= new PrintTrio();
        Thread t1= new Thread(new TaskTrio(10,printTrio,"ONE"),"FIRST_THREAD");
        Thread t2= new Thread(new TaskTrio(10,printTrio,"TWO"),"SECOND_THREAD");
        Thread t3= new Thread(new TaskTrio(10,printTrio,"THREE"),"THIRD_THREAD");
        t1.start();
        t2.start();
        t3.start();

    }
}
