package examples.eleven_11_12_hibernate.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainClass {
    private static SessionFactory factory;
    private static Session session = null;

    public static void main(String[] args) {
        factory = new Configuration()
                .configure("eleven_11_hibernate/hibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Author.class)
                .addAnnotatedClass(Reader.class)
                .addAnnotatedClass(Catalog.class)
                .buildSessionFactory();

        // CRUD
        try {

            session = factory.getCurrentSession();
            session.beginTransaction();

            //addAuthor("Rowling");
            //addAuthor("Herbert Schildt");
            //addAuthor("Dokins");

            /*
            Author authorHerbertSchildt = session.get(Author.class, 11);
            String title = "Herb Schildt’s Java Programming Cookbook";
            addBook(authorHerbertSchildt, title);
            String title_2 = "Programmer?s Reference>Herbert Schildt";
            addBook(authorHerbertSchildt, title_2);
            String title_3 = "Herb Schildt?s Java Programming Cookbook>Herbert Schildt";
            addBook(authorHerbertSchildt, title_3);
            */

            //READ
            //showBookById(11);

            /*
            List<Book> booksOfHerbertSchildt = new ArrayList<>();
            for(int i = 9; i <= 11; i++){
                booksOfHerbertSchildt.add(getBookById(i) );
            }
            Author authorHerbertSchildt = session.get(Author.class, 11);
            authorHerbertSchildt.setBooks(booksOfHerbertSchildt);
            System.out.println(authorHerbertSchildt);
            */


            /*
            Reader reader = session.get(Reader.class, 1);
            System.out.println(reader);
            Book book = session.get(Book.class, 15);
            reader.setBooks(new ArrayList<>(Arrays.asList(book)));
            */

            /*
            Reader reader = session.get(Reader.class, 1);
            Book book = session.get(Book.class, 16);
            reader.getBooks().add(book);
            //reader.getBooks().clear();
            System.out.println(reader);
            */


            //CREATE
            /*
            session = factory.getCurrentSession();
            Catalog catalog = new Catalog("Fantasy #15");
            session.save(catalog);
            session.getTransaction().commit();
            */

//          UPDATE
            /*
            session = factory.getCurrentSession();
            //session.beginTransaction();
            Book bookHarry = session.get(Book.class, 2);
            bookHarry.setTitle("Harry and something magical");
            session.detach(bookHarry);
            bookHarry.setTitle("new title");
            System.out.println(bookHarry);
            session.saveOrUpdate(bookHarry);
            session.getTransaction().commit();
            */

//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Catalog catalog = session.get(Catalog.class, 1L);
//            catalog.setTitle("Fantasy #8");
//            session.getTransaction().commit();
//            System.out.println(catalog);

//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Book bookJava1 = session.get(Book.class, 4);
//            session.delete(bookJava1);
//            session.getTransaction().commit();

            /*
             List<Book> allBooks = session.createQuery//("from Book").getResultList();
             //   ("from Book b where b.title = 'Harry Potter' ").getResultList();
             //   (" from Book b where b.title LIKE 'Harry%'  ").getResultList();
            */

            List<Book> allBooks = session.createQuery("from Book b where b.title = :title")
                    .setParameter("title", "Harry Potter")
                    .getResultList();
            for(Book book : allBooks) {
                System.out.println(book);
            }

            session.getTransaction().commit();


//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            session.createQuery("update Book set title = 'A'").executeUpdate();
//            session.createQuery("delete from Book where id = 3").executeUpdate();
//            session.getTransaction().commit();

//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Book book = session.get(Book.class, 1);
//            System.out.println(book);
//            session.getTransaction().commit();
//
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Author author = session.get(Author.class, 1);
//            System.out.println(author);
//            session.getTransaction().commit();

//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            List<Reader> readers = session.createQuery("from Reader").getResultList();
//            System.out.println(readers);
//            session.getTransaction().commit();

//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Author author = session.get(Author.class, 2);
//            session.delete(author);
//            session.getTransaction().commit();

        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            factory.close();
            session.close();
        }
    }


    private static Author getAuthorById(int id) throws Exception {
        return session.get(Author.class, id);
    }

    private static Book getBookById(int id) {
        return session.get(Book.class, id);
    }


    private static void showBookById(int id) {
        Book book = session.get(Book.class, id);
        System.out.println(book);
    }

    private static void addBook(Author author, String title) {
        Book book = new Book();
        book.setAuthor(author);
        book.setTitle(title);
        session.save(book);
    }

    private static void addAuthor(String name) throws Exception {
        Author author = new Author();
        author.setName(name);
        session.save(author);
    }


}
