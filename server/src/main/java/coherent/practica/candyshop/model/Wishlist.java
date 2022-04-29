package coherent.practica.candyshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "wishlist")
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wishlistId;
    @OneToMany(mappedBy = "wishlist",cascade = CascadeType.ALL)
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

    public Wishlist() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(int wishlistId) {
        this.wishlistId = wishlistId;
    }

    public List<WishlistCandy> getCandyAssoc() {
        return CandyAssoc;
    }

    public void setCandyAssoc(List<WishlistCandy> candyAssoc) {
        CandyAssoc = candyAssoc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
