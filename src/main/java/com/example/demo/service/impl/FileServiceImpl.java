package com.example.demo.service.impl;

import com.example.demo.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

@Service
@Slf4j
public class FileServiceImpl implements FileService {

    @Value("${upload.directory}")
    private String uploadDirectory;

    @Override
    public void upload(MultipartFile file) {
        // Check if the uploaded file is not empty
        if (Objects.isNull(file)) {
            return;
        }
        try {
            // Generate a unique filename to avoid conflicts
            if (Objects.nonNull(file.getOriginalFilename())) {
                String fileName = StringUtils.cleanPath(file.getOriginalFilename());
                String filePath = uploadDirectory + File.separator + fileName;

                // Save the uploaded file to the specified directory
                File destFile = new File(filePath);
                file.transferTo(destFile);
            }
        } catch (IOException e) {
            log.error("Error", e);
            e.printStackTrace();
        }
    }
}
