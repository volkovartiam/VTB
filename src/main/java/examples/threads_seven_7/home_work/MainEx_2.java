package examples.threads_seven_7.home_work;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class MainEx_2 {

    public static final int CARS_COUNT = 4;
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        Semaphore semaphore = new Semaphore(CARS_COUNT/2);
        Tunnel tunnel = new Tunnel();
        tunnel.setSemaphore(semaphore);

        Race race = new Race(new Road(60), tunnel, new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        CyclicBarrier cyclicBarrier = new CyclicBarrier(CARS_COUNT);
        CountDownLatch countDownLatch = new CountDownLatch(CARS_COUNT);
        for (int i = 0; i < cars.length; i++) {
            Thread thread = new Thread(cars[i]);
            cars[i].setCyclicBarrier(cyclicBarrier);
            cars[i].setCountDownLatch(countDownLatch);
            thread.start();
        }



        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }

}
