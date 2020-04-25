package padc.dat18c.renoblvd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "newsletter")
public class Newsletter{

    @Id
//    @Column(name = "idNews")
    private int idNews;
    private String email;

    public Newsletter() {
    }

    public Newsletter(int idNews, String email) {
        this.idNews = idNews;
        this.email = email;
    }

    public int getIdNews() {
        return idNews;
    }

    public void setIdNews(int idNews) {
        this.idNews = idNews;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
