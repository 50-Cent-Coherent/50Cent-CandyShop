package coherent.practica.candyshop.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
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

}