package multithreading;

import java.util.concurrent.Semaphore;

public class DeadLockUsingSemaphore {
    private CustomSemaphore s = new CustomSemaphore(1);
    private CustomSemaphore q = new CustomSemaphore(1);

    Thread t = new Thread(()->{
        try {
            s.acquire();
            System.out.println("Acquired lock on s 1"+Thread.currentThread().getName());
            Thread.sleep(100);
            q.acquire();
            Thread.sleep(100);
            System.out.println("Acquired lock on s 2");
            s.release();
            q.release();
            System.out.println("Releasing lock on s 1");
            System.out.println("Releasing lock on s 2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });

    Thread t1 = new Thread(()->{
        try {
            q.acquire();
            System.out.println("Acquired lock on s 1"+Thread.currentThread().getName());
            Thread.sleep(100);
            s.acquire();
            Thread.sleep(100);
            System.out.println("Acquired lock on s 2");
            q.release();
            s.release();
            System.out.println("Releasing lock on s 1");
            System.out.println("Releasing lock on s 2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });

    public static void main(String[] args) {
        DeadLockUsingSemaphore s = new DeadLockUsingSemaphore();
        s.t.start();
        s.t1.start();
    }
}

class CustomSemaphore{
    int permit;
    CustomSemaphore(int permit){
        this.permit = permit;
    }
    public synchronized void acquire() throws InterruptedException {
        if(permit > 0){
           permit--;
        } else {
            this.wait();
            permit--;
        }
    }

    public synchronized void release() throws InterruptedException {
            permit++;
            if(permit >0){
                this.notify();
        }
    }
}
