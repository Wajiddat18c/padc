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
@Table(name = "productstoimages")
public class Productstoimages {

    @Id
//    @Column(name = "id_Products_To_Images")
    private int idProductsToImages;
    private String files_id;
    private int products_id_Products;

    public Productstoimages() {
    }

    public Productstoimages(int idProductsToImages, String files_id, int products_id_Products) {
        this.idProductsToImages = idProductsToImages;
        this.files_id = files_id;
        this.products_id_Products = products_id_Products;
    }

    public int getIdProductsToImages() {
        return idProductsToImages;
    }

    public void setIdProductsToImages(int idProductsToImages) {
        this.idProductsToImages = idProductsToImages;
    }

    public String getFiles_id() {
        return files_id;
    }

    public void setFiles_id(String files_id) {
        this.files_id = files_id;
    }

    public int getProducts_id_Products() {
        return products_id_Products;
    }

    public void setProducts_id_Products(int products_id_Products) {
        this.products_id_Products = products_id_Products;
    }
}
