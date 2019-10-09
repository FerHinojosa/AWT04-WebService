/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.jalasoft.webservice.controller;

import com.jalasoft.webservice.model.ImageToImageConvert;
import com.jalasoft.webservice.model.ImageToImageCriteria;
import com.jalasoft.webservice.utils.Checksum;
import com.jalasoft.webservice.utils.Utils;
import com.jalasoft.webservice.model.*;
import org.apache.tika.exception.TikaException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * Implements Image to image controller classes.
 *
 * @author Fernando Hinojosa on 10/08/2019.
 * @version v1.0
 */
@RestController
@RequestMapping("/api/v1.0/imagetoimage")
public class ImageToImageController {

    /**
     * Converts image to the other extension format (PNG, JPG, GIF, TIFF).
     * @param file  has the file to be converted in another type.
     * @param ext the parameter have the ext information.
     * @return type request the image.
     * @throws IOException
     */
    @PostMapping
    public Response Convert (@RequestParam("file") MultipartFile file,
                             @RequestParam(value = "checksum",defaultValue = "false")String checksum,
                             @RequestParam(value = "metadata",defaultValue = "false")boolean metadata,
                             @RequestParam(value = "weight", defaultValue = "800") int weight,
                             @RequestParam(value = "height", defaultValue = "600") int height,
                             @RequestParam(value = "ext", defaultValue = "") String ext) throws IOException,
                             NoSuchAlgorithmException, TikaException, SAXException {
        String filePath = FileManager.getFilePath(file);
        Checksum checksum1 = new Checksum();
        Response response = new Response();
        DBManager db = new DBManager();
        String checksumResult = checksum1.checksum(filePath);
        ImageToImageConvert imageToImageConvert = new ImageToImageConvert();
        ImageToImageCriteria imageToImageCriteria = new ImageToImageCriteria();
        Utils utils = new Utils();

        String pathDb = "";
        if (checksum.equals(checksumResult)) {
            if (db.getPath(checksumResult).isEmpty()) {
                db.add(checksum,filePath);
            } else {
                pathDb= db.getPath(checksumResult);
            }
            imageToImageCriteria.setInputImagePath(filePath);
            imageToImageCriteria.setOutputImagePath(utils.getPublic()+"1"+"."+ext);
            imageToImageCriteria.setFormatName(ext);
            imageToImageCriteria.setHeight(height);
            imageToImageCriteria.setWeight(weight);
            imageToImageCriteria.setMetadata(metadata);
        } else {
            response.setStatus(Response.Status.BadRequest);
            response.setMessage("The cheksum is incorrect, please try again.");
            return response;
        }
        response = imageToImageConvert.convert(imageToImageCriteria);
        return response;
    }
}
