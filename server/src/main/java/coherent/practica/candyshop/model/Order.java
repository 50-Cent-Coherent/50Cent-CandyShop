package coherent.practica.candyshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderCandy> CandyAssoc = new ArrayList<>();
    private Timestamp date;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userdata_id",nullable = false)
    private UserData userData;

    public Order(Timestamp date, UserData userData) {
        this.date = date;
        this.userData = userData;
    }

}
