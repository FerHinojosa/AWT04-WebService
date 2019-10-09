/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.jalasoft.webservice.utils;

import com.jalasoft.webservice.model.Response;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implements the validator for tools in the web service.
 *
 * @author Raul Laredo
 * @version v1.0
 */
public class Validator{
    Logger logger = LoggerFactory.getLogger(Validator.class);
    Response response = new Response();
    /**
     * Validates image extensions
     * @param imageName for validation
     * @return true valid image, false invalid image
     */
    public boolean isValidImage(String imageName){
        //Extension verification
        boolean validExt = false;
        String ext =  FilenameUtils.getExtension(imageName);
        if (ext == "jpg" || ext == "png" || ext == "gif" || ext == "bmp") {
            validExt = true;
        }else{
            logger.error("The  image extension is invalid: - Method: " + new Object() {}.getClass().getEnclosingMethod().getName());
        }
        return validExt;
    }

    /**
     *Validates image extensions
     * @param imageName for validation the extension
     * @param lang for validate the language of the OCR
     * @return true valid image or false
     */
    public boolean isValidOCRImage(String imageName, String lang){
        //Extension verification
        boolean validExt = false;
        boolean validLang = false;
        String ext =  FilenameUtils.getExtension(imageName);
        if (ext == "jpg" || ext == "jpeg") {
            validExt = true;
        }else{
            logger.error("The  image extension is invalid: - Method: " + new Object() {}.getClass().getEnclosingMethod().getName());
        }
        if(lang=="eng"|| lang =="spa"){
            validLang = true;
        }else{
            logger.error("The  language is not allowed extension is invalid: - Method: " + new Object() {}.getClass().getEnclosingMethod().getName());
        }
        return validExt && validLang;
    }

    /**
     *Validates  video file for conversion
     * @param videoName for validation the extension of the video
     * @return true valid video or false
     */
    public boolean isValidVideo(String videoName){
        //Extension verification
        boolean validExt = false;
        String ext =  FilenameUtils.getExtension(videoName);
        if (ext == "avi" || ext == "mp4" || ext == "flv" || ext == "mov") {
            validExt = true;
        } else {
            logger.error("The  image extension is invalid: - Method: " + new Object() {}.getClass().getEnclosingMethod().getName());
        }
        return validExt;
    }

    /**
     *Validates audio files for conversion
     * @param audioName
     * @return valid audio or false
     */
    public boolean isValidAudio(String audioName){
        //Extension verification
        boolean validExt = false;
        String ext =  FilenameUtils.getExtension(audioName);
        if (ext == "mp3" || ext == "wav") {
            validExt = true;
        } else {
            logger.error("The  image extension is invalid: - Method: " + new Object() {}.getClass().getEnclosingMethod().getName());
            logger.error("Extension: " + ext + " is not allowed");
        }
        return validExt;
    }
}
