package Usecase;

import java.util.concurrent.atomic.AtomicReference;

public class PrintThreeThreads {
    public static void main(String[] args) {
        Object lock = new Object();
        AtomicReference<String> name = new AtomicReference<String>("Sapient");
        PrintSapient ps = new PrintSapient(name, lock);
        PrintGlobal pg = new PrintGlobal(name, lock);
        PrintMarket pm = new PrintMarket(name, lock);
        ps.start();
        pg.start();
        pm.start();
    }


}

class PrintSapient extends Thread {
    AtomicReference<String> name;
    Object lock;

    PrintSapient(AtomicReference<String> name, Object lock) {
        this.name = name;
        this.lock = lock;
    }

    public void run() {
        synchronized (lock) {
            while (true) {
                if (!name.get().equals("Sapient")) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Sapient");
                    name.set("Global");
                    lock.notifyAll();
                }
            }
        }
    }
}

class PrintGlobal extends Thread {
    AtomicReference<String> name;
    Object lock;

    PrintGlobal(AtomicReference name, Object lock) {
        this.name = name;
        this.lock = lock;
    }

    public void run() {
        synchronized (lock) {
            while (true) {
                if (!name.get().equals("Global")) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Global");
                    name.set("Market");
                    lock.notifyAll();
                }
            }
        }
    }
}

class PrintMarket extends Thread {
    AtomicReference<String> name;
    Object lock;

    PrintMarket(AtomicReference name, Object lock) {
        this.name = name;
        this.lock = lock;
    }

    public void run() {
        synchronized (lock) {
            while (true) {
                if (!name.get().equals("Market")) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Market");
                    name.set("Sapient");
                    lock.notifyAll();
                }
            }
        }
    }
}
