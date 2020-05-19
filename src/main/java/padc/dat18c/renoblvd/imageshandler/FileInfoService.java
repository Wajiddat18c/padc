package padc.dat18c.renoblvd.imageshandler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class FileInfoService {



    @Autowired
    FileInfoRepository fileInfoRepository;

    public FileInfo getFile(String fileId) {
        return fileInfoRepository.findById(fileId)
                .orElseThrow(null);
    }

    public List<FileInfo>getAll(){
        return (List<FileInfo>)fileInfoRepository.findAll();
    }
}