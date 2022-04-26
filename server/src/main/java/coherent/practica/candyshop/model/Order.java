package coherent.practica.candyshop.model;


import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderCandy> CandyAssoc;
    private Timestamp date;

    public Order(Timestamp date) {
        this.date = date;
    }

    public Order() {

    }

    public List<OrderCandy> getCandyAssoc() {
        return CandyAssoc;
    }

    public void setCandyAssoc(List<OrderCandy> candyAssoc) {
        CandyAssoc = candyAssoc;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
