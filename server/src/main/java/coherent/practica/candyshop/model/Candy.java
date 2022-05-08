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
@Table(name = "candy")
public class Candy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int candyId;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;
    private String name;
    private String description;
    private String photoUrl;
    private int quantity;
    private int price;
    @OneToMany(mappedBy = "candy",cascade = CascadeType.ALL)
    private List<WishlistCandy> WishlistAssoc = new ArrayList<>();
    @OneToMany(mappedBy = "candy",cascade = CascadeType.ALL)
    private List<OrderCandy> OrderAssoc = new ArrayList<>();

    public Candy(Category category, String name, String description, String photoUrl, int quantity, int price) {
        this.category = category;
        this.name = name;
        this.description = description;
        this.photoUrl = photoUrl;
        this.quantity = quantity;
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
