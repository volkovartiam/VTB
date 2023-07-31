package examples.thirteen_13_spring_core.example_5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("orderService")
public class OrderService {

    @Autowired
    Cart cart;

    public void makeOrder(){
        System.out.println("You make order, congratulation ");
        cart.showTotalCost();
    }

}
