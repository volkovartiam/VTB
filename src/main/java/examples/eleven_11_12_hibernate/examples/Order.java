package examples.eleven_11_12_hibernate.examples;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@Table(name = "customers_products")
public class Order{

    @EmbeddedId
    OrderKey orderKey;

    @ManyToOne
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    Customer customer;

    @ManyToOne
    @JoinColumn(name = "product_id" , insertable = false, updatable = false)
    Product product;

    @Column(name = "price")
    double price;
    @Override
    public String toString() {
        return "Order{" +
                "orderKey=" + orderKey +
                ", customer=" + customer+
                ", product=" + product +
                '}';
    }

}
