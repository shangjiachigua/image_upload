package com.caifu.image_upload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author tianwenwen
 * ClassName: MyController.java
 * version: 1.0.0
 * createTime: 2020年08月27日 15:43:57
 **/
@Controller
@RequestMapping("image")
public class MyController {
    @RequestMapping("toImagePage")
    public String toImagePage() {
        return "image";
    }

}
