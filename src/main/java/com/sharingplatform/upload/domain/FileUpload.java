package com.sharingplatform.upload.domain;

import com.sharingplatform.framework.mvc.SpringBootApplicationContext;
import com.sharingplatform.upload.application.FileParameters;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by hongying.fu on 1/19/2017.
 */
public class FileUpload {

    private FileParameters parameter = SpringBootApplicationContext.getBean(FileParameters.class);

    public String upload(MultipartFile multipartFile) throws Exception {
        String oriFileName = multipartFile.getOriginalFilename();
        String destDirectoryPath = computeDestDirectoryPath();
        String newFileName = computeNewFileName(oriFileName);

        String newPath = parameter.getRealPath() + File.separator + destDirectoryPath;
//        System.out.println("newPath:" + newPath);
        File file = new File(newPath, newFileName);
        if (!file.getParentFile().exists()) {
            if (!file.getParentFile().mkdirs()) {
                throw new Exception();
            }
        }
//        multipartFile.transferTo(file);
        inputSreamtoFile(multipartFile.getInputStream(),file);
        System.out.println("newPath + newFileName:" + newPath + newFileName);
        String suffix = oriFileName.substring(oriFileName.lastIndexOf(".")).toLowerCase();
        String[] fileSuffixs = new String[]{".jpg", ".png", ".bmp"};
        String thumbNameCreateCase = newFileName+ "_"+parameter.getWidthCreateCase() + "x" + parameter.getHeightCreateCase()  +suffix ;
        String thumbNameDetailCase =parameter.getWidthDetailCase() + "x" + parameter.getHeightDetailCase() + suffix ;
        for (String suf : fileSuffixs) {
            if (suf.equals(suffix)) {
                Thumbnails.of(newPath + newFileName)
                        .size(Integer.parseInt(parameter.getWidthCreateCase()), Integer.parseInt(parameter.getHeightCreateCase()))
                        .keepAspectRatio(false)
                        .toFile(newPath + thumbNameCreateCase);
                Thumbnails.of(newPath + newFileName)
                        .size(Integer.parseInt(parameter.getWidthDetailCase()), Integer.parseInt(parameter.getHeightDetailCase()))
                        .keepAspectRatio(false)
                        .toFile(newPath + thumbNameCreateCase+"_"+thumbNameDetailCase);

                return parameter.getUrl() + "/" + destDirectoryPath + thumbNameCreateCase+"_"+thumbNameDetailCase;
            }
        }
        return parameter.getUrl() + "/"  + destDirectoryPath + newFileName;
    }

    private String computeNewFileName(String oriFileName) {
        String fileNewName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            fileNewName = fileNewName + random.nextInt(10);
        }
        String suffix = oriFileName.substring(oriFileName.lastIndexOf(".")).toLowerCase();
        return fileNewName += suffix;
    }

    private String computeDestDirectoryPath() {
        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String year = sdf.format(date);

        SimpleDateFormat sdfMonth = new SimpleDateFormat("MM");
        String month = sdfMonth.format(date);

        SimpleDateFormat sdfDate = new SimpleDateFormat("dd");
        String dateString = sdfDate.format(date);

        return year + "/"  + month + "/"  + dateString + "/" ;
    }

    public void inputSreamtoFile(InputStream ins, File file){
        try{
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        }catch (Exception e){

        }finally {

        }
    }
}
