/**
 * padc.dat18c.renoblvd.imageshandler
 */
package padc.dat18c.renoblvd.imageshandler;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
/**
 * This class defines data structure.
 */
@Entity
@Table(name = "files")
public class FileInfo {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String fileName;

    private String fileType;

    public FileInfo() {

    }

    public FileInfo(String fileName, String fileType) {
        this.fileName = fileName;
        this.fileType = fileType;
    }

    public String getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

}
