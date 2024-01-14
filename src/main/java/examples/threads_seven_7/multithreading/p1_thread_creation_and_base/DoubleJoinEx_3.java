package examples.threads_seven_7.multithreading.p1_thread_creation_and_base;

public class DoubleJoinEx_3 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.err.println("t1-" + i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                System.err.println("t2-" + i);
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();


        try {
            System.err.println("1");
            t1.join();
            t2.start();
            //t2.join();
            System.err.println("2");
            System.err.println("3");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
