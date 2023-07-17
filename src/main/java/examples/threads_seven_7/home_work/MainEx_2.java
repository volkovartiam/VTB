package examples.threads_seven_7.home_work;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class MainEx_2 {

    public static final int CARS_COUNT = 4;
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        Race race = new Race(new Road(60), new Tunnel(CARS_COUNT), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }

        new Thread(new PrepRace()).start();

        CyclicBarrier cyclicBarrierStart = new CyclicBarrier(CARS_COUNT, new StartRace());
        CyclicBarrier cyclicBarrierStop = new CyclicBarrier(CARS_COUNT, new StopRace());
        CountDownLatch countDownLatch = new CountDownLatch(CARS_COUNT);
        for (Car car : cars) {
            Thread thread = new Thread(car);
            car.setCyclicBarrierStart(cyclicBarrierStart);
            car.setCyclicBarrierStop(cyclicBarrierStop);
            car.setCountDownLatch(countDownLatch);
            thread.start();
        }

        try{
            countDownLatch.await();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class PrepRace implements Runnable{
    @Override
    public void run() {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
    }
}


class StartRace implements Runnable{
    @Override
    public void run() {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
    }
}


class StopRace implements Runnable{
    @Override
    public void run() {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}