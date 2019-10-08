package com.jalasoft.webservice.utils;

import org.apache.commons.io.FilenameUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator{

    private Pattern pattern;
    private Matcher matcher;

    private static final String IMAGE_PATTERN =
            "([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)";
    private static final String VIDEO_PATTERN =
            "([^\\s]+(\\.(?i)(avi|mp4|flv))$)";
    private static final String LANG_PATTERN =
            "([^\\s]+(\\.(?i)(eng|spa))$)";

    public Validator(){
        pattern = Pattern.compile(IMAGE_PATTERN);
    }

    /**
     * Validate image with regular expression
     * @param imageName image for validation
     * @return true valid image, false invalid image
     */
    public boolean isValidImage(String imageName){
        //Extension verification
        boolean validExt = false;
        String ext =  FilenameUtils.getExtension(imageName);
        if (ext == "jpg" || ext == "png" || ext == "gif" || ext == "bmp") {
            validExt = true;
        } else {
            validExt = false;
        }
        return validExt;
    }




}
