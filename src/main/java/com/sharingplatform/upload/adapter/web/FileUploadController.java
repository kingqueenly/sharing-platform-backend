package com.sharingplatform.upload.adapter.web;

import com.sharingplatform.file.application.FileResult;
import com.sharingplatform.upload.application.FileUploadApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hongying.fu on 1/19/2017.
 */
@RestController
public class FileUploadController {
    @Autowired
    private FileUploadApplicationService fileUploadApplicationService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public FileResult upload(HttpServletRequest request) throws Exception {
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartHttpServletRequest.getFile("file");
//        System.out.println(request.getSession().getServletContext().getRealPath("/"));
        return fileUploadApplicationService.upload(multipartFile);
    }
}
