/**
 * padc.dat18c.renoblvd.imageshandler
 */
package padc.dat18c.renoblvd.imageshandler;
/**
 * This class handles errors
 */

public class FileStorageException extends RuntimeException {

    private static final long serialVersionUID = 1;

    public FileStorageException(String message) {
        super(message);
    }

    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}