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
 * Implements word to image converts.
 *
 * @author Raul Laredo
 * @version v1.0
 */
@RestController
@RequestMapping ("/api/v1.0/imagetoimage")
public class WordController {

    /**
     * Converts word to image
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

