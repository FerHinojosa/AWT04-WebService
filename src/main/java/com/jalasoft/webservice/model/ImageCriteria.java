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
 * Implements Image Criteria Class.
 *
 * @author Fernando Hinojosa on 09/24/2019.
 * @version v1.0
 */
public class ImageCriteria extends Criteria {
    private int dpi;
    private String destinationPath;
    private String extension;
    private boolean metadata;

    /**
     * Gets dpi resolution.
     * @return dpi value.
     */
    public int getDpi() {
        return dpi;
    }

    /**
     * Sets dpi resolution.
     * @param dpi set the resolution.
     */
    public void setDpi(int dpi) {
        this.dpi = dpi;
    }

    /**
     * Gets destination path.
     * @return destination path.
     */
    public String getDestinationPath() {
        return destinationPath;
    }

    /**
     * Sets destination path.
     * @param destinationPath set the destination path.
     */
    public void setDestinationPath(String destinationPath) {
        this.destinationPath = destinationPath;
    }

    /**
     * Gets extension.
     * @return extension.
     */
    public String getExtension() {
        return extension;
    }

    /**
     * Sets extension.
     * @param extension set the value.
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     * Gets metadata
     * @return extension.
     */
    public boolean getMetadata() {
        return metadata;
    }

    /**
     * Sets metadata
     * @param extension set the value.
     */
    public void setMetadata(boolean metadata) {
        this.metadata = metadata;
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
        if (this.dpi == 0){
            throw new ParamInvalidException(11, "bitRate");
        }
        if(this.extension==null){
            throw new ParamInvalidException(10, "filePath");
        }
        if (this.extension.isEmpty()){
            throw new ParamInvalidException(11, "filePath");
        }
        if (ext == "jpg" || ext == "gif" || ext == "jpeg"){
            throw new ParamInvalidException(12, "format");
        }
    }
}
