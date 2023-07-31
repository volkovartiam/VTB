package examples.thirteen_13_spring_core.example_5;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component("cart")
public class Cart {

    List<Product> productsInCart;

    Cart(){
        productsInCart = new ArrayList<>();
    }

     public void add(Product product){
        productsInCart.add(product);
     }

     public void showTotalCost(){
        double sum = 0;
         for (Product p : productsInCart) {
             sum += p.getPrice();
         }
         System.out.println(sum);
     }

     public void clearCart(){
        productsInCart.clear();
     }

    @PostConstruct
    public void fillCart(){

        Product product_1 = new Product(1 , "Product_1", 100.00);
        Product product_2 = new Product(2 , "Product_2", 200.00);
        Product product_3 = new Product(3 , "Product_3", 300.00);

        productsInCart.add(product_1);
        productsInCart.add(product_2);
        productsInCart.add(product_3);

    }


}
