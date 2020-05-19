package padc.dat18c.renoblvd.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Categories {

    @Id
    private int idCategories;
    private String name;

    public Categories() {
    }

    public Categories(int idCategories, String name) {
        this.idCategories = idCategories;
        this.name = name;
    }

    public int getIdCategories() {
        return idCategories;
    }

    public void setIdCategories(int idCategories) {
        this.idCategories = idCategories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
