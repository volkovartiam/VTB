package examples.threads_seven_7.sync;

import java.util.concurrent.CountDownLatch;

public class CountDownLatch_Ex2 {

    public static void main(String[] args) {

        final int THREADS_COUNT = 6;
        final CountDownLatch countDownLatch = new CountDownLatch(THREADS_COUNT);

        System.out.println("Begining");
        for(int i = 0; i < THREADS_COUNT; i++){
            int w = i;
            new Thread( ()-> {
                try {
                    Thread.sleep(500 + (int)(500 * Math.random()));

                    System.out.println("countDownLatch.getCount() " + countDownLatch.getCount() );
                    countDownLatch.countDown();

                    System.out.println("Thread " + w + "- готов.");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }).start();
        }
        try {
            countDownLatch.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Done");
    }
}
