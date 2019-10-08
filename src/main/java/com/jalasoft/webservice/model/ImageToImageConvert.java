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

/**
 * Implements Image to image converts classes.
 *
 * @author Fernando Hinojosa on 10/08/2019
 * @version v1.0
 */
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * The class implements methods to convert Image to image using ImageIO to change the extension file.
 *
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
            String destination = imgCriteria.getOutputImagePath();
            String ext = imgCriteria.getFormatName();

            FileInputStream inputStream = new FileInputStream(source);
            FileOutputStream outputStream = new FileOutputStream(destination);

            BufferedImage inputImage = ImageIO.read(inputStream);
            ImageIO.write(inputImage, ext, outputStream);

            outputStream.close();
            inputStream.close();

            response.setStatus(Response.Status.Ok);
            response.setUrl("done");
            return response;
        } catch (IOException e) {
            response.setStatus(Response.Status.BadRequest);
            return response;
        }
    }
}
