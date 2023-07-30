package examples.eleven_11_12_hibernate.hibernate_two;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {

        SessionFactory factory =null;
        Session session = null;

        try{
            factory = new Configuration()
                    .configure("eleven_11_hibernate/hibernate.cfg.xml")
                    .addAnnotatedClass(Item.class)
                    .buildSessionFactory();
            session = factory.getCurrentSession();

            /*
            Item item = new Item();
            item.setVal(0);
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
            */

            session.beginTransaction();
            Item item = session.get(Item.class, 1L);
            System.out.println(item.getVersion()); // <- 1
            item.setVal(20);
            session.flush();
            System.out.println(item.getVersion()); // <- 2
            item.setVal(30);
            session.flush();
            System.out.println(item.getVersion()); // <- 3
            session.getTransaction().rollback();

//            item = session.get(Item.class, 1L);
            System.out.println(item.getVersion()); // <- 1
            session.getTransaction().commit();


        } catch (Exception e){
            e.printStackTrace();
        } finally {
            factory.close();
            session.close();
        }



    }
}
