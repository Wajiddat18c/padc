package padc.dat18c.renoblvd.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "basket")
public class Basket {

    @Id
    private int idBasket;
    private String created;

    public Basket(){

    }

    public Basket(int idBasket, String created) {
        this.idBasket = idBasket;
        this.created = created;
    }

    public int getIdBasket() {
        return idBasket;
    }

    public void setIdBasket(int idBasket) {
        this.idBasket = idBasket;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String basketProducts_idbasketProducts) {
        this.created = basketProducts_idbasketProducts;
    }
}
