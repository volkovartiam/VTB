package examples.thirteen_13_spring_core.example_5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HomeWorkApp {
    public static void main(String[] args ){

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ProductService productService = context.getBean("service", ProductService.class);
        productService.printAll();

        System.out.println();
        Product product = productService.findByTitle("Product_2");
        System.out.println(product);

        OrderService orderService = context.getBean("orderService", OrderService.class);

        orderService.cart.add(product);
        orderService.makeOrder();



    }
}
