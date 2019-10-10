package com.jalasoft.webservice.controller;

import com.jalasoft.webservice.model.DBManager;
import com.jalasoft.webservice.model.ImageToImageConvert;
import com.jalasoft.webservice.model.ImageToImageCriteria;
import com.jalasoft.webservice.model.Response;
import com.jalasoft.webservice.utils.Checksum;
import com.jalasoft.webservice.utils.Utils;
import org.junit.Test;

import java.io.FileWriter;

import static org.junit.Assert.*;

public class ImageToImageControllerTest {

    @Test
    public void convert() {
        boolean thrown = false;
        try{
            String filePath = "";
            Checksum checksum1 = new Checksum();
            Response response = new Response();
            DBManager db = new DBManager();
            String checksumResult = checksum1.checksum(filePath);
            ImageToImageConvert imageToImageConvert = new ImageToImageConvert();
            ImageToImageCriteria imageToImageCriteria = new ImageToImageCriteria();
            Utils utils = new Utils();
            String pathDb = "";
            imageToImageCriteria.setInputImagePath(filePath);
            FileWriter writer = new FileWriter(utils.getPublic());
            imageToImageCriteria.setOutputImagePath(utils.getPublic());
            imageToImageCriteria.setFormatName("mp3");
            imageToImageCriteria.setHeight(150);
            imageToImageCriteria.setWeight(200);
            imageToImageCriteria.setMetadata(false);
            response = imageToImageConvert.convert(imageToImageCriteria);
        } catch (Exception e){
            thrown = true;
        }
        assertTrue(thrown);
    }
}