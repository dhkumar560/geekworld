package multithreading;

public class Deadlock {
    Object o1 = new Object();
    Object o2 = new Object();

    Thread t = new Thread(()->{
        synchronized (o1){
            try {
                System.out.println("in Thread 1");
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o2){

            }
        }

    });

    Thread t1 = new Thread(()->{
        synchronized (o2){
            try {
                System.out.println("in Thread 2");
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o1){

            }
        }

    });


    public static void main(String[] args) {
        Deadlock d = new Deadlock();
        d.t.start();
        d.t1.start();
    }
}

