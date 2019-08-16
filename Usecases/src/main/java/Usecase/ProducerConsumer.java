package Usecase;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProducerConsumer {
    public static void main(String[] args) {
        PC pc = new PC();

        Runnable r1 = () -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable r2 = () -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        new Thread(r1).start();
        new Thread(r2).start();
    }


    public static class PC {
        LinkedList l = new LinkedList();
        int capacity = 2;

        public void produce() throws InterruptedException {
            int value =0;
            while(true){
                synchronized (this){
                    while(l.size()==capacity)
                        wait();
                    Thread.sleep(100);
                    System.out.println("Producer produced"+value);
                    l.add(value++);
                    notifyAll();
                }

            }

        }
        public void consume() throws  InterruptedException{

            while(true){
                synchronized (this){
                    while(l.size()==0)
                        wait();
                    Thread.sleep(1000);
                    System.out.println("consumer consumed"+l.removeFirst());
                    notifyAll();
                }

            }
        }
    }
}