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
@Table(name = "customerinformation")
public class CustomerInformation {
    @Id
    private int idcustomerInformation;
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private String email;

    public CustomerInformation() {
    }

    public CustomerInformation(int idcustomerInformation, String firstName, String lastName, int phoneNumber, String email) {
        this.idcustomerInformation = idcustomerInformation;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getIdcustomerInformation() {
        return idcustomerInformation;
    }

    public void setIdcustomerInformation(int idcustomerInformation) {
        this.idcustomerInformation = idcustomerInformation;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
