package coherent.practica.candyshop.model;




import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "category",cascade = CascadeType.ALL)
    private List<Candy> candyList;
    private String name;
    private String description;

    public Category( String name, String description){
        this.name = name;
        this.description = description;
    }

    public Category() {
    }

    public List<Candy> getCandyList() {
        return candyList;
    }

    public void setCandyList(List<Candy> candyList) {
        this.candyList = candyList;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", candyList=" + candyList +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
