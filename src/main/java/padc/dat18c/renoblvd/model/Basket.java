/**
 * padc.dat18c.renoblvd.model
 */

package padc.dat18c.renoblvd.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class defines data structure.
 */

@Entity
@Table(name = "basket")
public class Basket {

    @Id
    private int idBasket;
    private int basketProducts_idbasketProducts;

    public Basket(){

    }

    public Basket(int idBasket, int basketProducts_idbasketProducts) {
        this.idBasket = idBasket;
        this.basketProducts_idbasketProducts = basketProducts_idbasketProducts;
    }

    public int getIdBasket() {
        return idBasket;
    }

    public void setIdBasket(int idBasket) {
        this.idBasket = idBasket;
    }

    public int getBasketProducts_idbasketProducts() {
        return basketProducts_idbasketProducts;
    }

    public void setBasketProducts_idbasketProducts(int basketProducts_idbasketProducts) {
        this.basketProducts_idbasketProducts = basketProducts_idbasketProducts;
    }
}
