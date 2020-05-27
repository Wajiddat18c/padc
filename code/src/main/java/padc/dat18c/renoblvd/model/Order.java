package padc.dat18c.renoblvd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_orders")
public class Order {
    @Id
    @Column(name = "id_order")
    private int idorder;
    @Column(name = "o_status")
    private String status;
    @Column(name = "o_date")
    private String date;
    @Column(name = "o_link")
    private String link;
    private int basket_idBasket;
    private int customer_idCustomer;

    public Order() {
    }

    public int getIdorder() {
        return idorder;
    }

    public void setIdorder(int idorder) {
        this.idorder = idorder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getBasket_idBasket() {
        return basket_idBasket;
    }

    public void setBasket_idBasket(int basket_idBasket) {
        this.basket_idBasket = basket_idBasket;
    }

    public int getCustomer_idCustomer() {
        return customer_idCustomer;
    }

    public void setCustomer_idCustomer(int customer_idCustomer) {
        this.customer_idCustomer = customer_idCustomer;
    }


}
