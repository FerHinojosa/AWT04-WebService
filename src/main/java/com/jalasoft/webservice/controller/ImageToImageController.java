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

/**
 * Implements Image to image controller classes.
 *
 * @author Fernando Hinojosa on 10/08/2019
 * @version v1.0
 */
import com.jalasoft.webservice.model.ImageToImageConvert;
import com.jalasoft.webservice.model.ImageToImageCriteria;
import com.jalasoft.webservice.utils.Utils;
import com.jalasoft.webservice.model.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1.0/imagetoimage")
public class ImageToImageController {

    /**
     * Converts image to the other extension format (PNG, JPG, GIF, TIFF)
     * @param file  has the file to be converted in another type
     * @param ext the parameter have the ext information
     * @return type request the image.
     * @throws IOException
     */
    @PostMapping
    public Response Convert (@RequestParam("file") MultipartFile file,
                             @RequestParam(value = "ext", defaultValue = "") String ext) throws IOException {
           String filePath = FileManager.getFilePath(file);
           ImageToImageConvert imageToImageConvert = new ImageToImageConvert();
           ImageToImageCriteria imageToImageCriteria = new ImageToImageCriteria();

           Utils utils = new Utils();

           imageToImageCriteria.setInputImagePath(filePath);
           imageToImageCriteria.setOutputImagePath(utils.getPublic());
           imageToImageCriteria.setFormatName(ext);

           Response response = new Response();
           response = imageToImageConvert.convert(imageToImageCriteria);

           return response;
    }
}
