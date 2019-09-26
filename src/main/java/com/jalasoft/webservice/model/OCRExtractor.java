package com.jalasoft.webservice.model;

import java.io.File;


import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sourceforge.tess4j.Tesseract;

/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
public class OCRExtractor {
    /**
     * Creates the Controller Model using Tesseract with the wrapper Tess4J.
     *
     * @param file for use it as file to extract the text.
     * @param lang language of the file and for using the data training.
     * @return String with the text of the image.
     * @throws To implement after this demo
     */
    public Response extract(String filePath, String lang){
        File imageFile = new File(filePath);
        ITesseract tesseract = new Tesseract();
        tesseract.setDatapath("../../../../ThirdParty/Tess4J/tessdata/"); // path to tessdata directory
        tesseract.setLanguage(lang);
        Response res = new Response();

        try {
            String result = tesseract.doOCR(imageFile);
            res.setStatus(Response.Status.Ok);
            res.setMessage(result);
            return res;
        } catch (TesseractException e){
            res.setStatus(Response.Status.BadRequest);
            return res;
        }
    }

}