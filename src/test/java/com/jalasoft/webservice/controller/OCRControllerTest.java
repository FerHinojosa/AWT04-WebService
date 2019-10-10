package com.jalasoft.webservice.controller;

import com.jalasoft.webservice.model.DBManager;
import com.jalasoft.webservice.model.OCRCriteria;
import com.jalasoft.webservice.model.OCRExtractor;
import com.jalasoft.webservice.model.Response;
import com.jalasoft.webservice.utils.Checksum;
import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

import static org.junit.Assert.*;

public class OCRControllerTest {
    boolean thrown;
    @Test
    public void OCRExtractor() {
        MultipartFile file = null;
        try {
            String filePath = FileManager.getFilePath(file);
            Checksum checksum1 = new Checksum();
            Response test = new Response();
            DBManager db = new DBManager();
            String checksumResult = checksum1.checksum(filePath);
            String pathDb = "";
            OCRExtractor ocr = new OCRExtractor();
            OCRCriteria ocrCriteria = new OCRCriteria("eng", filePath);
            test = ocr.convert(ocrCriteria);
        }catch (Exception e){
            thrown = true;
        }
    assertTrue(thrown);
    }

}