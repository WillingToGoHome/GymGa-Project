package com.willingtogohome.gymga.emp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class PicUploadController {

    @PostMapping("/emp/picupload")
    public String picupload(@RequestParam MultipartFile picFile, Model model) {

        System.out.println("picFile = " + picFile);

        String root = "src/main/resources/static";
        String filePath = root + "/uploadFiles";
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
            picFile.transferTo(new File(filePath + "/" + savedName));
            model.addAttribute("message", "파일 업로드 완료!");
        } catch (IOException e) {
            model.addAttribute("message", "파일 업로드 실패!");
        }

        return "/emp/regist";
    }
}
