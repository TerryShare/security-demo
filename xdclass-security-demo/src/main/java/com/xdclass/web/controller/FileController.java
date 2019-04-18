package com.xdclass.web.controller;


import com.xdclass.domain.FileInfo;

import java.io.*;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Greated by Terry on 2019/4/19
 * Time: 3:29
 */
@RestController
@RequestMapping("/file")
public class FileController {

    String folder= "D:\\git\\security-demo\\xdclass-security-demo\\src\\main\\java\\com\\xdclass\\web\\controller";

    @PostMapping
    public FileInfo upload(MultipartFile file) throws IOException {
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());



        File localFile=new File(folder,new Date().getTime()+"text");
        file.transferTo(localFile);
        return  new FileInfo(localFile.getAbsolutePath());
    }

    @GetMapping("/{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws Exception {

        try (InputStream inputStream = new FileInputStream(new File(folder, id + ".txt"));
             OutputStream outputStream = response.getOutputStream();) {

            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition", "attachment;filename=test.txt");

            IOUtils.copy(inputStream, outputStream);
            outputStream.flush();
        }

    }

}
