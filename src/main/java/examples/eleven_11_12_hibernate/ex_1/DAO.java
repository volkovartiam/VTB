package examples.eleven_11_12_hibernate.ex_1;

import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class DAO {

    private SessionFactory factory;

    public DAO(){
        factory = HibernateUtil.getSessionFactory();
    }

    public void close(){
        HibernateUtil.close();
    }

    public boolean insert(Object object){
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.save(object);
            session.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean remove(Object object){
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.remove(object);
            session.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean removeCustomer(String name){
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Query query = session.createQuery("from Customer where name =: paramName");
            query.setParameter("paramName", name);
            Customer customer = (Customer) query.setMaxResults(1).getSingleResult();

            session.remove(customer);
            session.getTransaction().commit();
            return true;

        } catch (PersistenceException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean removeProduct(String name){
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Query query = session.createQuery("from Product where name =: paramName");
            query.setParameter("paramName", name);
            Product product = (Product)  query.setMaxResults(1).getSingleResult();

            session.remove(product);
            session.getTransaction().commit();
            return true;

        } catch (PersistenceException e) {
            e.printStackTrace();
            return false;
        }
    }


    public  void getCustomerByName(String name){
        try( Session session = factory.getCurrentSession() ){

            session.beginTransaction();
            Query query = session.createQuery("from Customer where name =: paramName");
            query.setParameter("paramName", name);
            Customer customer = (Customer) query.setMaxResults(1).getSingleResult();
            System.out.println( "List of products by customer " + name );
            System.out.println( customer.getProducts() );
            session.getTransaction().commit();
        }catch (HibernateException | NoResultException e){
            e.printStackTrace();
        }
    }


    public  void findPersonsByProductTitle(String title){
        try( Session session = factory.getCurrentSession() ){

            session.beginTransaction();
            Query query = session.createQuery("from Product where name =: paramName");
            query.setParameter("paramName", title);
            Product product = (Product) query.setMaxResults(1).getSingleResult();
            System.out.println( "List of customers by product " + title );
            System.out.println( product.getCustomers() );
            session.getTransaction().commit();
        }catch (HibernateException | NoResultException e){
            e.printStackTrace();
        }
    }


    public  void makeOrder(String name, String title){
        try( Session session = factory.getCurrentSession() ){

            session.beginTransaction();
            Query query = session.createQuery("from Product where name =: paramName");
            query.setParameter("paramName", title);
            Product product = (Product) query.setMaxResults(1).getSingleResult();


            Query newQuery = session.createQuery("from Customer where name =: paramName");
            newQuery.setParameter("paramName", name);
            Customer customer = (Customer) newQuery.setMaxResults(1).getSingleResult();

            /*
            Order order

            session.save(object);
            */
            session.getTransaction().commit();

            System.out.println( "List of customers by product " + title );
            System.out.println( product.getCustomers() );
            session.getTransaction().commit();
        }catch (HibernateException | NoResultException e){
            e.printStackTrace();
        }
    }





    public  Product getProductByName(String name){
        try( Session session = factory.getCurrentSession() ){

            Query query = session.createQuery("from Product where name =: paramName");
            query.setParameter("paramName", name);
            Product prodeuct = (Product) query.getSingleResult();
            session.getTransaction().commit();
            return prodeuct;
        }catch (HibernateException | NoResultException e){
            e.printStackTrace();
            return null;
        }
    }


    public static void showProductsByPerson(Customer customer){
        System.out.println("\n" + "List of products by selected customer");
        List<Product> products = customer.getProducts() ;
        for ( Product p : products ){
            System.out.println( p.getId() + " " + p.getName() + " " + p.getPrice() );
        }
    }

    public static void findPersonsByProductTitle(Product product){
        System.out.println("\n" + "List of customers by selected product");
        List<Customer> customers = product.getCustomers() ;
        for ( Customer c : customers ){
            System.out.println( c.getId()  + " " + c.getName()  );
        }
    }


    public void getCustomersByName(String name) {

            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery("from Customer where name =: paramName");
            query.setParameter("paramName", name);
            List<Customer> list = query.getResultList();
            if (!list.isEmpty()) {
                System.out.println("Customers with name " + name + ": ");
                for (Customer c : list) {
                    System.out.println(c);
                }
            } else {
                System.out.println("In this database no customers with name: " + name);
            }
            session.getTransaction().commit();

        /*finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        } */
    }


}
