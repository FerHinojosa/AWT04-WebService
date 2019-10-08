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

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * The class implements methods to convert Image to image using ImageIO to change the extension file.
 *
 * @author Fernando Hinojosa on 10/08/2019.
 * @version v1.0
 */
public class ImageToImageConvert implements IConvert{

    /**
     * Creates the Image to image convert using ImageIO to change the extension file.
     * @param criteria
     * @return response
     */
    @Override
    public Response convert(Criteria criteria) {
        Response response = new Response();
        ImageToImageCriteria imgCriteria = (ImageToImageCriteria) criteria;
        try {
            String source = imgCriteria.getInputImagePath();
            File destination = new File(imgCriteria.getOutputImagePath());
            String ext = imgCriteria.getFormatName();

            FileInputStream inputStream = new FileInputStream(source);
            FileOutputStream outputStream = new FileOutputStream(destination);
            int weight = imgCriteria.getWeight();
            int height = imgCriteria.getHeight();

            BufferedImage inputImage = ImageIO.read(inputStream);
            BufferedImage resized = resize(inputImage,weight, height);
            ImageIO.write(resized, ext, outputStream);
            outputStream.close();
            inputStream.close();

            response.setStatus(Response.Status.Ok);
            response.setUrl(destination.getName());
            ZipFiles zipFiles = new ZipFiles();
            String [] filePaths = new String[1];
            filePaths[0]=destination.getName();
            zipFiles.zipFiles(filePaths);
            return response;
        } catch (IOException e) {
            response.setStatus(Response.Status.BadRequest);
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
