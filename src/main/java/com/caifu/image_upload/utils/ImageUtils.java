package com.caifu.image_upload.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author tianwenwen
 * @version 1.0.0
 * ClassName ImageUtils.java
 * createTime 2020年08月27日 13:36
 **/
public class ImageUtils {


    public static String imageSingleUpload(MultipartFile file,String fileUploadPath,String imageUrlPath) throws Exception {

        //获取文件上传名
        String filename = file.getOriginalFilename();
        //文件上传路径
        String fileUploadPathStr = fileUploadPath + File.separator + filename;
        File uploadFile = new File(fileUploadPathStr);
        //文件不存在创建
        if (!uploadFile.getParentFile().exists()) {
            uploadFile.getParentFile().mkdirs();
        }
        //上传
        file.transferTo(uploadFile);
        //文件访问路径
        String imageUrl = imageUrlPath + filename;
        System.out.println("imageUrl = " + imageUrl);
        return imageUrl;

    }
}
