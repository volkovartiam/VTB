package examples.threads_seven_7.sync;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrier_Ex3 {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);

        for(int i = 0; i < 10; i++){
            int w = i;
            new Thread( ()-> {
                try {
                    System.out.println("Поток " + w + "- готовится.");
                    Thread.sleep(100 + (int)(3000 * Math.random()));
                    System.out.println("Поток " + w + "- готов.");
                    cyclicBarrier.await();
                    System.out.println("Поток " + w + "- запустился.");
                }catch (InterruptedException | BrokenBarrierException e){
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
