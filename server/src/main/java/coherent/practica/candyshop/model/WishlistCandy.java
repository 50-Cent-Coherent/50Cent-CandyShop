package coherent.practica.candyshop.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "wishlist_candies")
public class WishlistCandy implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int WishlistCandyId;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "wishlist_id")
    private Wishlist wishlist;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "candy_id")
    private Candy candy;

    private int quantity;

    public WishlistCandy(Wishlist wishlist, Candy candy, int quantity) {
        this.wishlist = wishlist;
        this.candy = candy;
        this.quantity = quantity;
    }

    public WishlistCandy() {

    }

    public int getWishlistCandyId() {
        return WishlistCandyId;
    }

    public void setWishlistCandyId(int wishlistCandyId) {
        WishlistCandyId = wishlistCandyId;
    }

    public Wishlist getWishlist() {
        return wishlist;
    }

    public void setWishlist(Wishlist wishlist) {
        this.wishlist = wishlist;
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
