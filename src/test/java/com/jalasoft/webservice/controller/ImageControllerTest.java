package com.jalasoft.webservice.controller;

import com.jalasoft.webservice.model.DBManager;
import com.jalasoft.webservice.model.ImageConvert;
import com.jalasoft.webservice.model.ImageCriteria;
import com.jalasoft.webservice.model.Response;
import com.jalasoft.webservice.utils.Checksum;
import com.jalasoft.webservice.utils.Utils;
import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;

import static org.junit.Assert.*;

public class ImageControllerTest {
    @Test
    public void convert() {
        MultipartFile file = null;
        boolean thrown = false;
        try{
            String filePath = FileManager.getFilePath(file);
            Checksum checksum1 = new Checksum();
            Response response = new Response();
            DBManager db = new DBManager();
            String checksumResult = checksum1.checksum(filePath);
            ImageConvert img = new ImageConvert();
            ImageCriteria imageCriteria = new ImageCriteria();
            Utils utils = new Utils();
            String pathDb = "";
            imageCriteria.setFilePath(filePath);
            imageCriteria.setDpi(250);
            imageCriteria.setDestinationPath(utils.getPublic());
            imageCriteria.setExtension("mp3");
            imageCriteria.setMetadata(true);
        }catch (Exception e){
            thrown = true;
        }
        assertTrue(thrown);
    }
}