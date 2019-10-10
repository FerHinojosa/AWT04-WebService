package com.jalasoft.webservice.controller;

import com.jalasoft.webservice.utils.Utils;
import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static org.junit.Assert.*;

public class FileManagerTest {

    @Test
    public void getFilePath() {
        boolean thrown = false;
        try{
            MultipartFile file = null;
            Utils utils = new Utils();
            String filePath = utils.getTemp() + file.getOriginalFilename();
            Path location = Paths.get(filePath);
            Files.copy(file.getInputStream(), location, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e){
            thrown= true;
        }
    }
}