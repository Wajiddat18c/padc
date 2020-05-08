package padc.dat18c.renoblvd.imageshandler;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "files")
public class DatabaseFile {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String fileName;

    private String fileType;

    @Lob
    private byte[] data;

    private String products_id_Products;

    public DatabaseFile(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }

    public DatabaseFile(String fileName, String fileType, byte[] data, String products_id_Products) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
        this.products_id_Products = products_id_Products;
    }

    public DatabaseFile() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getProducts_id_Products() {
        return products_id_Products;
    }

    public void setProducts_id_Products(String products_id_Products) {
        this.products_id_Products = products_id_Products;
    }
}