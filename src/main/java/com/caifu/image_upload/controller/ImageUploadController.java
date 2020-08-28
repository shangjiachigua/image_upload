package com.caifu.image_upload.controller;

import com.caifu.image_upload.utils.ImageUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tianwenwen
 * version 1.0.0
 * ClassName ImageUploadController.java
 * createTime 2020年08月27日 13:53:04
 **/
@Controller
@RequestMapping("upload")
public class ImageUploadController {

    //文件上传地址 生产
    @Value("${Image.IMAGE_UPLOAD_PATH_LINUX}")
    private String fileUploadPath;

    //文件访问url
    @Value("${Image.IMAGE_URL_PATH_LINUX}")
    private String imageUrlPath;

    @RequestMapping("uploadImage")
    @ResponseBody
    public Map<String, Object> uploadImage(MultipartFile file) {
        Map<String, Object> map = new HashMap<>(15);
        try {
            String imageUrl = ImageUtils.imageSingleUpload(file,fileUploadPath,imageUrlPath);
            map.put("imageUrl", imageUrl);
            map.put("code", "200");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", "500");
            map.put("msg", "网络异常");
        }
        return map;
    }

}
