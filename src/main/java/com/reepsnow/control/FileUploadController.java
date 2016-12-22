package com.reepsnow.control;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

	@RequestMapping("/upload")
    @ResponseBody
    public String handleFileUpload(@RequestParam("file") MultipartFile file,@RequestParam("name")String name) throws IOException {
        byte[] bytes = file.getBytes();
        String fileName = file.getOriginalFilename();
        String file_path = "d:\\";
        System.out.println(name);
        String newFileName = file_path+UUID.randomUUID()+fileName.substring(fileName.lastIndexOf("."));
        File newFile = new File(newFileName);
        file.transferTo(newFile);
        return "file uploaded successfully.";
    }
}