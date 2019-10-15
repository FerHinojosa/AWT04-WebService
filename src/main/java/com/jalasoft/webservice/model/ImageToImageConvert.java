/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.jalasoft.webservice.model;

import com.jalasoft.webservice.utils.Checksum;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * The class implements methods to convert Image to image using ImageIO to change the extension file.
 *
 * @author Fernando Hinojosa on 10/08/2019.
 * @version v1.0
 */
public class ImageToImageConvert implements IConvert{
    Logger logger = LoggerFactory.getLogger(ImageToImageConvert.class);
    /**
     * Creates the Image to image convert using ImageIO to change the extension file.
     * @param criteria
     * @return response
     */
    @Override
    public Response convert(Criteria criteria) {
        Checksum checksum = new Checksum();
        MetadataFileCreator metadataFileCreator = new MetadataFileCreator();
        Response response = new Response();
        logger.info("Starting Response Model - Method: " +         new Object() {}.getClass().getEnclosingMethod().getName());
        ImageToImageCriteria imgCriteria = (ImageToImageCriteria) criteria;
        try {
            String source = imgCriteria.getInputImagePath();
            System.out.println(imgCriteria.getOutputImagePath());
            File destination = new File(imgCriteria.getOutputImagePath());
            String ext = imgCriteria.getFormatName();
            String zipName = checksum.checksum(imgCriteria.getInputImagePath());
            FileInputStream inputStream = new FileInputStream(source);
            FileOutputStream outputStream = new FileOutputStream(destination);
            int weight = imgCriteria.getWeight();
            int height = imgCriteria.getHeight();
            BufferedImage inputImage = ImageIO.read(inputStream);
            BufferedImage resized = resize(inputImage,weight, height);
            ImageIO.write(resized, ext, outputStream);
            outputStream.close();
            inputStream.close();
            ZipFiles zipFiles = new ZipFiles();
            String [] filePaths;
            if(imgCriteria.getMetadata()){
                filePaths = new String[2];
                filePaths[0]=imgCriteria.getOutputImagePath();
                String fileMetaD;
                fileMetaD = metadataFileCreator.getMetada(imgCriteria.getOutputImagePath());
                filePaths[1] = fileMetaD;
            } else {
                filePaths = new String[1];
                filePaths[0] = imgCriteria.getOutputImagePath();
            }
            zipFiles.zipFiles(filePaths,zipName);
            response.setStatus(Response.Status.Ok);
            response.setMessage("Success, file was converted");
            response.setUrl(zipName + ".zip");
            logger.info("Image to image conversion succesfully - Method: " + 
            new Object() {}.getClass().getEnclosingMethod().getName());
            return response;
        } catch (IOException e) {
            response.setStatus(Response.Status.BadRequest);
            System.out.println(e.getMessage());
            logger.error("Image to image conversion Error - Method: " +
            new Object() {}.getClass().getEnclosingMethod().getName());
            return response;
        } catch (NoSuchAlgorithmException e) {
            response.setStatus(Response.Status.BadRequest);
            logger.error("Image to image conversion Error - Method: " +
            new Object() {}.getClass().getEnclosingMethod().getName());
            return response;

        } catch (SAXException e) {
            response.setStatus(Response.Status.BadRequest);
            logger.error("Image to image conversion Error - Method: " +
            new Object() {}.getClass().getEnclosingMethod().getName());
            return response;
        } catch (TikaException e) {
            response.setStatus(Response.Status.BadRequest);
            logger.error("Image to image conversion Error - Method: " +
            new Object() {}.getClass().getEnclosingMethod().getName());
            return response;
        }
    }
    private static BufferedImage resize(BufferedImage img, int height, int width) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }
}
