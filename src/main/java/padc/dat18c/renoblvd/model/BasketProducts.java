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
@Table(name = "basketproducts")
public class BasketProducts {

    @Id
//    @Column(name = "id_basketProducts")
    private int idbasketProducts;
    private int amount;
    private int products_idProducts;


    public BasketProducts() {
    }

    public BasketProducts(int idbasketProducts, int amount, int products_idProducts) {
        this.idbasketProducts = idbasketProducts;
        this.amount = amount;
        this.products_idProducts = products_idProducts;
    }


    public int getIdbasketProducts() {
        return idbasketProducts;
    }

    public void setIdbasketProducts(int idbasketProducts) {
        this.idbasketProducts = idbasketProducts;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getProducts_idProducts() {
        return products_idProducts;
    }

    public void setProducts_idProducts(int products_idProducts) {
        this.products_idProducts = products_idProducts;
    }
}
