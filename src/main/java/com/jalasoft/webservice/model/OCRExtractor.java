package com.jalasoft.webservice.model;

import java.io.File;


import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sourceforge.tess4j.Tesseract;

/**
 *
 * @project WebService feature(OCRExtractor)
 * @author Ramalaso on 09/23/2019
 */
public class OCRExtractor {

    public String extract(String filePath, String lang){
        File imageFile = new File(filePath);
        ITesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Users\\fernandohinojosa\\Documents\\Tess4J\\tessdata"); // path to tessdata directory
        tesseract.setLanguage(lang);
        try {
            String result = tesseract.doOCR(imageFile);
            return result;
        } catch (TesseractException e){
            return "e.getMessage()";
        }
    }

}