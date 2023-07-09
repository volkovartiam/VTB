package examples.eleven_11_12_hibernate.ex_1;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@Table(name = "customers_products")
public class Order{

    @Embeddable
    public static class Id implements Serializable{

        @Column(name = "customer_id")
        int customerId;

        @Column(name = "product_id")
        int productId;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Id id = (Id) o;
            return customerId == id.customerId &&
                    productId == id.productId;
        }

        @Override
        public int hashCode() {
            return customerId + productId;
        }
    }

    @EmbeddedId
    Id id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;

    /*
    @Column(name = "price")
    double price;
    */

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer.getId() + " " + customer.getName() +
                ", product=" + product.getId() + " " + product.getName()  +
                '}';
    }

}
