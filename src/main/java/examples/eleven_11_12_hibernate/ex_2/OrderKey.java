package examples.eleven_11_12_hibernate.ex_2;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@Embeddable
public class OrderKey implements Serializable{

    @Column(name = "product_id")
    long productId;

    @Column(name = "customer_id")
    long customerId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderKey orderKey = (OrderKey) o;
        return  Objects.equals( getCustomerId(), orderKey.getCustomerId() )  &&
                Objects.equals( getProductId(), orderKey.getProductId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerId(), getProductId());
    }

    @Override
    public String toString() {
        return "OrderKey{" +
                "customerId=" + customerId +
                ", productId=" + productId +
                '}';
    }
}
