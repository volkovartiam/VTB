package examples.eleven_11_12_hibernate.hibernate_three;

import examples.eleven_11_12_hibernate.hibernate_two.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class MainClass {
    private static SessionFactory factory;
    private static Session session = null;

    public static void main(String[] args) {
        factory = new Configuration()
                .configure("eleven_11_hibernate/hibernate.cfg.xml")
                .addAnnotatedClass(Items.class)
                .buildSessionFactory();

        try {

            session = factory.getCurrentSession();

            session.beginTransaction();
            Items item = session.get(Items.class, 1);
            //session.save(item);
            //System.out.println(item);
            //session.getTransaction().commit();

            item.setVal(1);
            System.out.println(item.getVal()); // <- 1
            session.flush();

            item.setVal(2);
            System.out.println(item.getVal()); // <- 2
            session.flush();

            item.setVal(3);
            System.out.println(item.getVal()); // <- 3
            session.getTransaction().rollback();

            //session.beginTransaction();
            System.out.println(item.getVal()); // <- 1
            session.getTransaction().commit();

        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            factory.close();
            session.close();
        }
    }


}
