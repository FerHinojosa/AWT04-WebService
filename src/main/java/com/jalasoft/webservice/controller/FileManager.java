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

import com.jalasoft.webservice.utils.Utils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Implements FileManager for the controllers
 * @author Fernando Hinojosa on 09/26/2019
 * @version v1.0
 */
public class FileManager {

    /**
     * This classes return the file path.
     * @param file the parameter have the file path information.
     * @return string with the path of the file.
     * @throws IOException
     */
    public static String getFilePath(@RequestParam("file") MultipartFile file) throws IOException {
        Utils utils = new Utils();
        String filePath = utils.getTemp() + file.getOriginalFilename();
        Path location = Paths.get(filePath);
        Files.copy(file.getInputStream(), location, StandardCopyOption.REPLACE_EXISTING);
        return filePath;
    }
}
