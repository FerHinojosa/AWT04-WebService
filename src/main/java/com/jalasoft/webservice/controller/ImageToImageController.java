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

import com.jalasoft.webservice.model.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

/**
 * Implements the image convert.
 *
 * @author Raul Laredo
 * @version v1.0
 */
@RestController
@RequestMapping ("/api/v1.0/image")
public class ImageToImageController {

    /**
     * Converts the image data type in another type
     *
     * @throws IOException
     */
    @PostMapping
    public Response convert(@RequestParam("sourceFile") MultipartFile sourceFile
    ) throws IOException {

        Response response = new Response();
        return response;
    }
}

