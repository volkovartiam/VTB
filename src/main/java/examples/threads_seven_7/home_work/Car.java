package examples.threads_seven_7.home_work;

import lombok.Setter;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;


public class Car implements Runnable {

    @Setter
    CyclicBarrier cyclicBarrierStart;
    @Setter
    CyclicBarrier cyclicBarrierStop;
    @Setter
    CountDownLatch countDownLatch;


    private static long CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public long position;
    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cyclicBarrierStart.await();
            cyclicBarrierStart.reset();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        position = CARS_COUNT - countDownLatch.getCount() + 1; // + 1 для начала отсчета с единицы
        countDownLatch.countDown();


        try {
            countDownLatch.await();
            cyclicBarrierStop.await();
            if(position == 1){
                System.out.println(name + " Win!!!");
            } else {
                System.out.println(name + " занял место № " + position);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


}
