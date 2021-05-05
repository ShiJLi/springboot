package com.shijl.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件上传
 */
@Controller
@Slf4j
public class FormController {


    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "form/form_layouts";
    }

    /**
     * MultipartFile  自动封装上传的文件
     *
     * 单文件及多文件上传
     * @param email
     * @param username
     * @param headerImg
     * @param photos
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart ("photos") MultipartFile[]  photos) throws IOException {

        log.info("上传文件信息:email:{}.username={},headerImg={},photos={}",
                email,username,headerImg.getSize(),photos.length);

        if(!headerImg.isEmpty()){
            String originalFilename = headerImg.getOriginalFilename();
            //模拟文件存到服务器
            headerImg.transferTo(new File("D:\\workspace\\code\\" +
                    ""+originalFilename));
        }
        if(photos.length>0){
            for (MultipartFile photo : photos) {
                if(!photo.isEmpty()){
                    photo.transferTo(new File("D:\\workspace\\code\\"+photo.getOriginalFilename()));
                }
            }
        }
        return "main";
    }
}
