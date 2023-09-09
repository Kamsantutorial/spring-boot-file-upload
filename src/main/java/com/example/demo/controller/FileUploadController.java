package com.example.demo.controller;

import com.example.demo.service.FileService;
import com.example.demo.vo.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
public class FileUploadController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public ResponseMessage<Void> uploadFile(@RequestParam("file") MultipartFile file) {
        this.fileService.upload(file);
        return new ResponseMessage<Void>().body(null).success();
    }

}
