package examples.threads_seven_7.sync;

import java.util.concurrent.Semaphore;

public class SemathorEx_1 {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(2);
        for(int i = 0; i < 5; i++){
            int w = i;
            new Thread( () -> {
                try {
                    System.out.println("Поток " + w + " перед семафором.");
                    semaphore.acquire();
                    System.out.println("Поток " + w + " получил доступ к ресурсу.");
                } catch (InterruptedException e){
                       e.printStackTrace();
                } finally {
                    System.out.println("Поток " + w + " освободил ресурс");
                    semaphore.release();
                }
            }).start();
        }

    }
}
