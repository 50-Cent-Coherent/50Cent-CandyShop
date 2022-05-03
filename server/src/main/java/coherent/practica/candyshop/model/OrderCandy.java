package coherent.practica.candyshop.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
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

}
