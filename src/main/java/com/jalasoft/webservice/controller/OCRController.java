/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
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
 * Implements the OCR Model class to extract text data for use in controller class.
 *
 * @author Raul Laredo
 * @version 1.0
 */

@RestController
@RequestMapping ("/api/v1.0/ocr")
public class OCRController {

    /**
     * Creates the Controller Model using Tesseract with the wrapper Tess4J.
     *
     * @param file for use it as file to extract the text.
     * @param lang language of the file and for using the data training.
     * @return String with the text of the image.
     * @throws To implement after this demo
     */

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



