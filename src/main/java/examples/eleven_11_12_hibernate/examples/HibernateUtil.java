package examples.eleven_11_12_hibernate.examples;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory factory;

    static SessionFactory getSessionFactory(){
        if(factory == null ){
            factory = new Configuration()
                    .configure("eleven_11_hibernate/hibernateApp.cfg.xml")
                    .buildSessionFactory();
        }
        return factory;
    }

    static void close(){
        if(factory != null){
            factory.close();
        }
    }

    static void open(){
        if(factory != null){
            factory.openSession();
        }
    }

}
