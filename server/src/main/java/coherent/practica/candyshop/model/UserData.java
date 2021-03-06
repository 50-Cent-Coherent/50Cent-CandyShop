package coherent.practica.candyshop.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
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
    @OneToMany(mappedBy = "userData")
    private List<Order> orders = new ArrayList<>();

    public UserData(String firstName, String secondName, String email, String address, String telephone, User user) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.address = address;
        this.telephone = telephone;
        this.user = user;
    }

}
