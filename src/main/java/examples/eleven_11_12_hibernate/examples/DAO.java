package examples.eleven_11_12_hibernate.examples;

import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class DAO {

    private final SessionFactory factory;

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

            List<Order> orders = customer.getOrders();
            orders.forEach( o ->
                    System.out.println( "Products for customer " + customer.getName() +
                           " " + o.getProduct().toString() ) );

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
            List<Order> orders = product.getOrders();

            for (Order o: orders) {
                System.out.println( o.getCustomer() + " " );
            }
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

            System.out.println();
            System.out.println();
            System.out.println(product);
            Customer customer = (Customer) newQuery.setMaxResults(1).getSingleResult();
            System.out.println();
            System.out.println();
            System.out.println(customer);

            OrderKey orderKey = new OrderKey();
            orderKey.setCustomerId(customer.getId());
            orderKey.setProductId(product.getId());

            Order order = new Order();
            order.setOrderKey(orderKey);
            order.setCustomer(customer);
            order.setProduct(product);

            order.setPrice(product.getPrice());
            session.save(order);

            System.out.println();
            System.out.println( "Order = "  + order );
            System.out.println();

            session.getTransaction().commit();

        }catch (HibernateException | NoResultException e){
            e.printStackTrace();
        }
    }


}
