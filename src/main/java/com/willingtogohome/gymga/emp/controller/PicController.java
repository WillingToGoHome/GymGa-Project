package com.willingtogohome.gymga.emp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Controller
public class PicController {

    @PostMapping("/emp/picupload")
    public String picupload(@RequestParam MultipartFile picFile, Model model) {

        System.out.println("picFile = " + picFile);

        String root = "src/main/resources/static";
        String filePath = root + "/uploadImages";
        File dir = new File(filePath);

        if (!dir.exists()) {
            dir.mkdirs();
        }

        String originFileName = picFile.getOriginalFilename();
        System.out.println("originFileName = " + originFileName);
        String ext = originFileName.substring(originFileName.lastIndexOf("."));
        System.out.println("ext = " + ext);

        String savedName = UUID.randomUUID() + ext;
        System.out.println("savedName = " + savedName);

        try {
//            picFile.transferTo(new File(filePath + "/" + savedName));
            picFile.transferTo(new File(filePath + "/" + originFileName));
            model.addAttribute("message", "파일 업로드 완료!");
        } catch (Exception e) {
            model.addAttribute("message", "파일 업로드 실패!");
            e.printStackTrace();
        }

        return "/emp/regist";
    }

    @PostMapping("emp/test")
    public String profileUpdate(@RequestParam MultipartFile picFile, Model model) {

        System.out.println("picFile = " + picFile);

        String root = "src/main/resources/static";
        String filePath = root + "/uploadImages";
        File dir = new File(filePath);

        if (!dir.exists()) {
            dir.mkdirs();
        }

        String originFileName = picFile.getOriginalFilename();
        System.out.println("originFileName = " + originFileName);
        String ext = originFileName.substring(originFileName.lastIndexOf("."));
        System.out.println("ext = " + ext);

        String savedName = UUID.randomUUID() + ext;
        System.out.println("savedName = " + savedName);

        try {
//            picFile.transferTo(new File(filePath + "/" + savedName));
            picFile.transferTo(new File(filePath + "/" + originFileName));
            model.addAttribute("message", "파일 업로드 완료!");
        } catch (Exception e) {
            model.addAttribute("message", "파일 업로드 실패!");
            e.printStackTrace();
        }

        return "redirect:/emp/test";
    }
}
