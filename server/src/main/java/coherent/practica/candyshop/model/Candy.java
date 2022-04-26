package coherent.practica.candyshop.model;



import jdk.dynalink.linker.LinkerServices;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "candy")
public class Candy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int candyId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;
    private String name;
    private String description;
    private String photoUrl;
    private int quantity;
    private int price;
    @OneToMany(mappedBy = "candy",cascade = CascadeType.ALL)
    private List<WishlistCandy> WishlistAssoc;
    @OneToMany(mappedBy = "candy",cascade = CascadeType.ALL)
    private List<OrderCandy> OrderAssoc;

    public Candy(Category category, String name, String description, String photoUrl, int quantity, int price) {
        this.category = category;
        this.name = name;
        this.description = description;
        this.photoUrl = photoUrl;
        this.quantity = quantity;
        this.price = price;

    }

    public Candy() {

    }

    public List<OrderCandy> getOrderAssoc() {
        return OrderAssoc;
    }

    public void setOrderAssoc(List<OrderCandy> orderAssoc) {
        OrderAssoc = orderAssoc;
    }

    public List<WishlistCandy> getWishlistAssoc() {
        return WishlistAssoc;
    }

    public void setWishlistAssoc(List<WishlistCandy> wishlistAssoc) {
        WishlistAssoc = wishlistAssoc;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getCandyId() {
        return candyId;
    }

    public void setCandyId(int candyId) {
        this.candyId = candyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Candy{" +
                "candyId=" + candyId +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }


}
