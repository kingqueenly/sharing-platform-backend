package com.benz.upload.application;

import com.benz.file.application.FileResult;
import com.benz.upload.domain.FileUpload;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by hongying.fu on 1/19/2017.
 */
@Service
public class FileUploadApplicationService {
    public FileResult upload(MultipartFile multipartFile) throws Exception {
        String filePath =new FileUpload().upload(multipartFile);
        return new FileResult(filePath);
    }
}
