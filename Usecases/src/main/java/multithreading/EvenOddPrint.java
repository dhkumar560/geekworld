package multithreading;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class EvenOddPrint {
    private Object lock = new Object();
    private AtomicLong num = new AtomicLong();

    Thread even = new Thread(()->{
        while(num.get()<100){
        synchronized (lock){
            if(num.get()%2!=0){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Print even number by Thread"+Thread.currentThread().getName()+"::"+num.toString());
                num.incrementAndGet();
                lock.notifyAll();
            }
        }}
    },"Thread-even");

    Thread odd = new Thread(()-> {
        while (num.get() < 100){
            synchronized (lock) {
                if (num.get() % 2 == 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Print Odd number by Thread" + Thread.currentThread().getName() + "::" + num.toString());
                    num.incrementAndGet();
                    lock.notifyAll();
                }
            }
    }
    },"Thread-Odd");

    public static void main(String[] args) {
        EvenOddPrint p = new EvenOddPrint();
        p.even.start();
        p.odd.start();
    }
}
