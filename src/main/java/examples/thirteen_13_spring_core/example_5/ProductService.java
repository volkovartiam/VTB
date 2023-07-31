package examples.thirteen_13_spring_core.example_5;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component("service")
public class ProductService {

    List<Product> products;

    @PostConstruct
    public void insertListOfProducts(){

        products = new ArrayList<>();

        Product product_1 = new Product(1 , "Product_1", 100.00);
        Product product_2 = new Product(2 , "Product_2", 200.00);
        Product product_3 = new Product(3 , "Product_3", 300.00);
        Product product_4 = new Product(4 , "Product_4", 400.00);
        Product product_5 = new Product(5 , "Product_5", 500.00);

        Product product_6 = new Product(6 , "Product_1", 600.00);
        Product product_7 = new Product(7 , "Product_2", 700.00);
        Product product_8 = new Product(8 , "Product_3", 800.00);
        Product product_9 = new Product(9 , "Product_4", 900.00);
        Product product_10 = new Product(10 , "Product_5", 1000.00);

        products.add(product_1);
        products.add(product_2);
        products.add(product_3);
        products.add(product_4);
        products.add(product_5);

        products.add(product_6);
        products.add(product_7);
        products.add(product_8);
        products.add(product_9);
        products.add(product_10);
    }

    public void printAll() {
        for (Product p : products) {
            System.out.println(p);
        }
    }

    Product findByTitle(String title){
        Product product = null;

        for(Product p : products){
            if(p.getTitle().equals(title)){
                product = p;
                break;
            }
        }
        return product;
    }

}
