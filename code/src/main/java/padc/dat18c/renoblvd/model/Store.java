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
@Table(name = "store")
public class Store {
    @Id
    private int idStore;
    private String name;
    private String address;
    private String opening_hours;
    private String email;
    private String description;
    private String phone_number;
    private int vat;

    public Store(){
    }

    public Store(int idStore, String name, String address, String opening_hours, String email, String description, String phone_number, int vat) {
        this.idStore = idStore;
        this.name = name;
        this.address = address;
        this.opening_hours = opening_hours;
        this.email = email;
        this.description = description;
        this.phone_number = phone_number;
        this.vat = vat;
    }

    public int getIdStore() {
        return idStore;
    }

    public void setIdStore(int idStore) {
        this.idStore = idStore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpening_hours() {
        return opening_hours;
    }

    public void setOpening_hours(String opening_hours) {
        this.opening_hours = opening_hours;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getVat() {
        return vat;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }
}

