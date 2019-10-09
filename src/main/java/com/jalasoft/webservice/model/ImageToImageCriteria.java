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

import org.apache.commons.io.FilenameUtils;

/**
 * Implements ImageToImage Criteria Class.
 *
 * @author Fernando Hinojosa on 10/08/2019
 * @version v1.0
 */
public class ImageToImageCriteria extends Criteria {
    private String inputImagePath;
    private String outputImagePath;
    private String formatName;
    private int height;
    private int weight;

     /**
     * Gets input path.
     * @return input image path.
     */
    public String getInputImagePath() {
        return inputImagePath;
    }

    /**
     *
     * @param inputImagePath
     */
    public void setInputImagePath(String inputImagePath) {
        this.inputImagePath = inputImagePath;
    }

    /**
     * Gets destination path.
     * @return output image path.
     */
    public String getOutputImagePath() {
        return outputImagePath;
    }

    /**
     * Gets destination path.
     * @param outputImagePath
     */
    public void setOutputImagePath(String outputImagePath) {
        this.outputImagePath = outputImagePath;
    }

    /**
     * Gets extension.
     * @return extension file.
     */
    public String getFormatName() {
        return formatName;
    }

    /**
     * Sets extension file.
     * @param formatName
     */
    public void setFormatName(String formatName) {
        this.formatName = formatName;
    }

    /**
     * Gets height of the image.
     * @return the height.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets height of the image.
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Gets weight of the image.
     * @return
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Sets weight of the image.
     * @param weight
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Implements the validation needs for the conversion of an image.
     *
     * @author Raul Laredo
     * @version v1.0
     */
    @Override
    public void Validate() throws ParamInvalidException {
        String ext =  FilenameUtils.getExtension(this.filePath);
        if(this.filePath==null){
            throw new ParamInvalidException(10, "filePath");
        }

        if (this.filePath.isEmpty()){
            throw new ParamInvalidException(11, "filePath");
        }

        if (this.height == 0){
            throw new ParamInvalidException(11, "bitRate");
        }

        if (this.weight == 0){
            throw new ParamInvalidException(11, "bitRate");
        }

        if(this.inputImagePath==null){
            throw new ParamInvalidException(10, "filePath");
        }

        if (this.inputImagePath.isEmpty()){
            throw new ParamInvalidException(11, "filePath");
        }
        if(this.formatName==null){
            throw new ParamInvalidException(10, "filePath");
        }

        if (this.formatName.isEmpty()){
            throw new ParamInvalidException(11, "filePath");
        }
        if (ext == "jpg" || ext == "gif" || ext == "jpeg"){
            throw new ParamInvalidException(12, "format");
        }

    }
}
