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

import com.jalasoft.webservice.model.ImageConvert;
import com.jalasoft.webservice.model.ImageCriteria;
import com.jalasoft.webservice.model.Response;
import com.jalasoft.webservice.utils.Utils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Implements ImageController with the Imageconvert classes
 * @author Fernando Hinojosa on 09/24/2019
 * @version v1.0
 */
@RestController
@RequestMapping("/api/v1.0/image")
public class ImageController {

    /**
     * Implements the Convert classes
     * @param file the parameter have the file path information
     * @param dpi the parameter have the dpi information
     * @param ext the parameter have the ext information
     * @return
     * @throws IOException
     */
        @PostMapping
        public Response Convert (@RequestParam("file") MultipartFile file,
                                      @RequestParam (value = "dpi", defaultValue = "") int dpi,
                                      @RequestParam(value = "ext", defaultValue = "") String ext) throws IOException {
            String filePath = FileManager.getFilePath(file);

            ImageConvert img = new ImageConvert();
            ImageCriteria imageCriteria = new ImageCriteria();
            Utils utils = new Utils();

            imageCriteria.setFilePath(filePath);
            imageCriteria.setDpi(dpi);
            imageCriteria.setDestinationPath(utils.getPublic());
            imageCriteria.setExtension(ext);
            Response response = new Response();
            response = img.convert(imageCriteria);

            return response;
        }
}
