package com.ocr.ocr;

import java.io.File;


import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sourceforge.tess4j.Tesseract;


@RestController
public class OCRExtractor {
    @RequestMapping("/ocr")
    public String extract(){
        File imageFile = new File("C:\\Users\\RaulLaredo\\Downloads\\Tess4J-3.4.8-src\\Tess4J\\tessdata\\example1spa.jpg");
        ITesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Users\\RaulLaredo\\Downloads\\Tess4J-3.4.8-src\\Tess4J\\tessdata"); // path to tessdata directory
        tesseract.setLanguage("spa");
        try {
            String result = tesseract.doOCR(imageFile);
            return result;
        } catch (TesseractException e){
            return "e.getMessage()";
        }
    }

}