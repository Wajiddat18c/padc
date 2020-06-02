/**
 * padc.dat18c.renoblvd.model
 */
package padc.dat18c.renoblvd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class defines data structure.
 */
@Entity
@Table(name = "products")
public class Products {

    @Id
//    @Column(name = "id_Products")
    private int idProducts;
    private String name;
    private String brand;
    private int pris;
    private String description;
    private int categories_idCategories;


    public Products() {
    }

    public Products(int idProducts, String name, String brand, int pris, String description, int categories_idCategories) {
        this.idProducts = idProducts;
        this.name = name;
        this.brand = brand;
        this.pris = pris;
        this.description = description;
        this.categories_idCategories = categories_idCategories;
    }

    public int getIdProducts() {
        return idProducts;
    }

    public void setIdProducts(int idProducts) {
        this.idProducts = idProducts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategories_idCategories() {
        return categories_idCategories;
    }

    public void setCategories_idCategories(int categories_idCategories) {
        this.categories_idCategories = categories_idCategories;
    }
}


