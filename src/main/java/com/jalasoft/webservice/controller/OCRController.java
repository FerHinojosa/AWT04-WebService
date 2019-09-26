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

import com.jalasoft.webservice.model.OCRCriteria;
import com.jalasoft.webservice.model.OCRExtractor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 *The class is an endpoit for OCR
 *
 * @author Fernando Hinojosa on 09/23/2019
 * @version v1.0
 */
@RestController
@RequestMapping ("/api/v1.0/ocr")
public class OCRController{

    /**
     *
     * @param file the parameter have the file path information
     * @param lang the parameter have the language set to recognize the text
     * @return returns a String with the text obtain and in case of error shows the error message
     * @throws IOException control the input output exception to handle file used in the method
     */
    @PostMapping
    public String OCRExtractor (@RequestParam("file") MultipartFile file, @RequestParam(value = "lang", defaultValue = "") String lang) throws IOException {
        String filePath = "./src/ThirdParty/Tess4J/tessdata/" + file.getOriginalFilename();
        Path location = Paths.get(filePath);
        Files.copy(file.getInputStream(), location, StandardCopyOption.REPLACE_EXISTING);
        OCRExtractor ocr = new OCRExtractor();
        //OCRCriteria ocrCriteria = new OCRCriteria(lang,file.getOriginalFilename());
        OCRCriteria ocrCriteria = new OCRCriteria(lang,filePath);
        String test = ocr.convert(ocrCriteria);
        return test;
    }
}
