package com.sharingplatform.upload.application;

import com.sharingplatform.file.application.FileResult;
import com.sharingplatform.upload.domain.FileUpload;
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
