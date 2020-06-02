/**
 * padc.dat18c.renoblvd.imageshandler
 */
package padc.dat18c.renoblvd.imageshandler;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
/**
 * This class handles all of the Crud-operations
 */
@Service
public class DatabaseFileService {

    @Autowired
    private DatabaseFileRepository dbFileRepository;

    /**
     * This method store images to our database.
     * @param file uses the buildin class MultipartFile to handel all of the file information
     * @return save file to database.
     */
    public DatabaseFile storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            DatabaseFile dbFile = new DatabaseFile(fileName, file.getContentType(), file.getBytes());

            return dbFileRepository.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public DatabaseFile getFile(String fileId) {
        return dbFileRepository.findById(fileId)
                .orElseThrow(null);
    }

    public List<DatabaseFile>getAll(){
        return (List<DatabaseFile>)dbFileRepository.findAll();
    }



}