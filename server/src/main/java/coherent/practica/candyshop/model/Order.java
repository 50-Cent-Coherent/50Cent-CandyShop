package coherent.practica.candyshop.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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

    public Order() {

    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
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
