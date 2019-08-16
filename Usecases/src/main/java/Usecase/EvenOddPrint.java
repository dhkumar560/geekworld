package Usecase;

import java.util.concurrent.atomic.AtomicLong;

public class EvenOddPrint {
    public static void main(String[] args) {
        AtomicLong num = new AtomicLong(1);
        Object lock = new Object();
        EvenPrint e = new EvenPrint(num, lock);
        OddPrint o = new OddPrint(num, lock);
        e.start();
        o.start();
    }
}

class EvenPrint extends Thread {
    private AtomicLong num;
    Object lock;

    EvenPrint(AtomicLong num, Object lock) {
        this.num = num;
        this.lock = lock;
    }

    public void run() {
        synchronized (lock) {
            while (true) {
                if (num.get() % 2 != 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("print Even" + num);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    num.incrementAndGet();
                    lock.notifyAll();
                }
            }
        }
    }
}

class OddPrint extends Thread {
    private AtomicLong num;
    Object lock;

    OddPrint(AtomicLong num, Object lock) {
        this.num = num;
        this.lock = lock;
    }

    public void run() {
        synchronized (lock) {
            while (true) {
                if (num.get() % 2 == 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("print Odd" + num);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    num.incrementAndGet();
                    lock.notifyAll();
                }
            }
        }
    }
}
