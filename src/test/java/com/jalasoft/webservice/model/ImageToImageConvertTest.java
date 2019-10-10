package com.jalasoft.webservice.model;

import com.jalasoft.webservice.utils.Checksum;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.Assert.*;

public class ImageToImageConvertTest {
    ImageToImageConvert imageToImageConvert = new ImageToImageConvert();
    boolean thrown = false;
    @Test
    public void convert() {
        Checksum checksum = new Checksum();
        MetadataFileCreator metadataFileCreator = new MetadataFileCreator();
        Response response = new Response();
        ImageToImageCriteria imgCriteria = new ImageToImageCriteria();
        try {
            String source = imgCriteria.getInputImagePath();
            System.out.println(imgCriteria.getOutputImagePath());
            File destination = new File(imgCriteria.getOutputImagePath());
            String ext = imgCriteria.getFormatName();
            String zipName = checksum.checksum(imgCriteria.getInputImagePath());
            FileInputStream inputStream = new FileInputStream(source);
            FileOutputStream outputStream = new FileOutputStream(destination);
            BufferedImage inputImage = ImageIO.read(inputStream);
            outputStream.close();
            inputStream.close();
            ZipFiles zipFiles = new ZipFiles();
            String [] filePaths;
            filePaths = new String[2];
            filePaths[0]=imgCriteria.getOutputImagePath();
            String fileMetaD;
            fileMetaD = metadataFileCreator.getMetada(imgCriteria.getOutputImagePath());
            filePaths[1] = fileMetaD;
        } catch (Exception e) {
            thrown = true;
        }
        assertTrue(thrown);
    }
}