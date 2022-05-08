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
@Table(name = "wishlist")
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wishlistId;
    @OneToMany(mappedBy = "wishlist")
    private List<WishlistCandy> CandyAssoc = new ArrayList<>();
    private String name;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    public Wishlist(String name, User user) {
        this.name = name;
        this.user = user;
    }

}
