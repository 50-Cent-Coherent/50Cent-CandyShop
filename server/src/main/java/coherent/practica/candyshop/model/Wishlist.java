package coherent.practica.candyshop.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "wishlist")
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wishlistId;
    @OneToMany(mappedBy = "wishlist",cascade = CascadeType.ALL)
    private List<WishlistCandy> CandyAssoc;
    private String name;

    public Wishlist(String name) {
        this.name = name;
    }

    public Wishlist() {

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
