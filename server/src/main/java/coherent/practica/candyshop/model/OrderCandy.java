package coherent.practica.candyshop.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orders_candies")
public class OrderCandy implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int OrderCandyId;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "candy_id")
    private Candy candy;

    private int quantity;

    public OrderCandy(Order order, Candy candy, int quantity) {
        this.order = order;
        this.candy = candy;
        this.quantity = quantity;
    }

    public OrderCandy() {

    }

    public int getOrderCandyId() {
        return OrderCandyId;
    }

    public void setOrderCandyId(int orderCandyId) {
        OrderCandyId = orderCandyId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Candy getCandy() {
        return candy;
    }

    public void setCandy(Candy candy) {
        this.candy = candy;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
