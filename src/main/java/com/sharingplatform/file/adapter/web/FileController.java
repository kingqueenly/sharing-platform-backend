package com.sharingplatform.file.adapter.web;

import com.sharingplatform.file.application.FileApplicationService;
import com.sharingplatform.file.application.FileResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;

/**
 * Created by hongying.fu on 12/21/2016.
 */
@RestController
public class FileController {

    @Autowired
    private FileApplicationService fileApplicationService;

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public FileResult upload(HttpServletRequest request) throws Exception {
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartHttpServletRequest.getFile("file");
        InputStream inputStream = multipartFile.getInputStream();
        String oriFileName = multipartFile.getOriginalFilename();

        return fileApplicationService.upload(inputStream, oriFileName);
    }

}
