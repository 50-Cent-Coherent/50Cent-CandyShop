package coherent.practica.candyshop.model;

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
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "category")
    private List<Candy> candyList = new ArrayList<>();
    private String name;
    private String description;

    public Category( String name, String description){
        this.name = name;
        this.description = description;
    }


    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
