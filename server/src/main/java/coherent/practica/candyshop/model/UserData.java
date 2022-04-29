package coherent.practica.candyshop.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_data")
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userDataId;
    private String firstName;
    private String secondName;
    private String email;
    private String address;
    private String telephone;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;
    @OneToMany(mappedBy = "userData",cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

    public UserData(String firstName, String secondName, String email, String address, String telephone, User user) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.address = address;
        this.telephone = telephone;
        this.user = user;
    }

    public UserData() {

    }

    public int getUserDataId() {
        return userDataId;
    }

    public void setUserDataId(int userDataId) {
        this.userDataId = userDataId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
