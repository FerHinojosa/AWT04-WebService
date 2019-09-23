package com.jalasoft.webservice.controller;


import com.jalasoft.webservice.model.OCRExtractor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 *
 * @project WebService feature(OCRController)
 * @author Fernando Hinojosa on 09/23/2019
 */
@RestController
@RequestMapping ("/api/v1.0/ocr")
public class OCRController {

    @PostMapping
    public String OCRExtractor (@RequestParam("file") MultipartFile file, @RequestParam(value = "lang", defaultValue = "") String lang) throws IOException {

        String filePath = "C:\\Users\\fernandohinojosa\\Desktop\\" + file.getOriginalFilename();
        Path location = Paths.get(filePath);

        Files.copy(file.getInputStream(), location, StandardCopyOption.REPLACE_EXISTING);

        OCRExtractor ocr = new OCRExtractor();
        String res = ocr.extract(filePath,lang);

        return res;
    }
}



