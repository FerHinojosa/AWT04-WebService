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
import com.jalasoft.webservice.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.jalasoft.webservice.utils.Checksum;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * The class is an end point for OCR.
 *
 * @author Fernando Hinojosa on 09/23/2019.
 * @version v1.0
 */
@RestController
@RequestMapping ("/api/v1.0/ocr")
public class OCRController{
    Logger logger = LoggerFactory.getLogger(OCRController.class);
    /**
     *
     * @param file the parameter have the file path information.
     * @param lang the parameter have the language set to recognize the text.
     * @return returns a String with the text obtain and in case of error shows the error message.
     * @throws IOException control the input output exception to handle file used in the method.
     */
    @PostMapping
    public Response OCRExtractor (@RequestParam("file") MultipartFile file,
                                  @RequestParam(value = "checksum",defaultValue = "false")String checksum,
                                  @RequestParam(value = "lang", defaultValue = "") String lang) throws IOException,
                                  NoSuchAlgorithmException {

            logger.info("Starting OCR Controller - Method: " +
                    new Object() {
                    }.getClass().getEnclosingMethod().getName());
            String filePath = FileManager.getFilePath(file);
            Checksum checksum1 = new Checksum();
            Response test = new Response();
            DBManager db = new DBManager();
            String checksumResult = checksum1.checksum(filePath);
            String pathDb = "";
        try {
            if (checksum.equals(checksumResult)) {
                logger.error("The cheksum send is not match - Method: " +
                        new Object() {
                        }.getClass().getEnclosingMethod().getName());
                if (db.getPath(checksumResult).isEmpty()) {
                    db.add(checksum, filePath);
                } else {
                    pathDb = db.getPath(checksumResult);
                }
                OCRExtractor ocr = new OCRExtractor();
                OCRCriteria ocrCriteria = new OCRCriteria(lang, filePath);
                test = ocr.convert(ocrCriteria);
                return test;
            } else {
                test.setStatus(Response.Status.BadRequest);
                test.setMessage("The cheksum is incorrect, please try again.");
                return test;
            }
        } catch (IOException e){
            test.setMessage(e.getMessage());
            return test;
        }
    }
}
