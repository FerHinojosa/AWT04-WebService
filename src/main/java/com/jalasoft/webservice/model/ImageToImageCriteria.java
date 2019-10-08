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
 * Implements ImageToImage Criteria Class.
 *
 * @author Fernando Hinojosa on 10/08/2019
 * @version v1.0
 */
public class ImageToImageCriteria extends Criteria {
    private String inputImagePath;
    private String outputImagePath;
    private String formatName;

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
     * @return output image path
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
}
