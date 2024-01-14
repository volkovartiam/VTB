package examples.eleven_11_12_hibernate.hibernate_four;

import jakarta.persistence.OptimisticLockException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import static java.lang.Thread.sleep;


public class MainClass {

    private static final int NUMBER_OF_THREADS = 4;


    public static void main(String[] args) {

        try {
            prepareData();
            changeItemsWithThreads();
            countSumVal();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void changeItemsWithThreads() {
        CountDownLatch countDownLatch = new CountDownLatch(NUMBER_OF_THREADS);
        Thread[] threads = new Thread[NUMBER_OF_THREADS];

        try(    SessionFactory factory = new Configuration()
                    .configure("eleven_11_hibernate/hibernate.cfg.xml")
                    .addAnnotatedClass(Item.class)
                    .buildSessionFactory();             ){
            for(int i = 0; i < NUMBER_OF_THREADS; i++){
                final int u = i;
                threads[i] = new Thread( ()-> {
                    System.out.println("Thread " + u + " started" );
                    for (int j = 0; j < 20; j++){
                        boolean update = false;
                        long random = (long) (Math.random() * 39 ) + 1;
                        while (!update){
                            Session session = factory.getCurrentSession();
                            session.beginTransaction();

                            Item item = session.get(Item.class, random);
                            int tmp = item.getVal();
                            item.setVal(++tmp);
                            uncheckableSleep(5);
                            try {
                                session.save(item);
                                session.getTransaction().commit();
                                update = true;
                                System.out.println("Thread " + j);
                            } catch (OptimisticLockException e){
                                session.getTransaction().rollback();
                            }
                            if(session != null){
                                session.close();
                            }
                        }
                    }
                    countDownLatch.countDown();
                });
                threads[i].start();
            }
            try {
                countDownLatch.await();
                System.out.println("End");
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }

    public static void uncheckableSleep(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void prepareData() throws IOException {
        SessionFactory factory = new Configuration()
                .configure("eleven_11_hibernate/hibernate.cfg.xml")
                .addAnnotatedClass(Item.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            List<Item> items = session.createQuery("from Item").getResultList();
            for (Item item : items) {
                System.out.println(item);
            }
        } finally {
            factory.close();
            if(session!= null){
                session.close();
            }
        }
    }

    public static void countSumVal(){
        try(    SessionFactory factory = new Configuration()
                .configure("eleven_11_hibernate/hibernate.cfg.xml")
                .addAnnotatedClass(Item.class)
                .buildSessionFactory();             ) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Object o = session.createNativeQuery("SELECT SUM(val) FROM items;").getSingleResult();
            System.out.println(o);
            if(session != null){
                session.close();
            }
        }
    }

}
