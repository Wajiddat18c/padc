package padc.dat18c.renoblvd.imageshandler;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileInfoRepository extends JpaRepository<FileInfo, String> {
}