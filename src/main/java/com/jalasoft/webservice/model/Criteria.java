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
 * Implements Criteria classes to use with the interface.
 *
 * @author Fernando Hinojosa on 09/23/2019.
 * @version v1.0
 */
public abstract class Criteria {
    protected String filePath;

    /**
     * Gets file path.
     * @return string with file path.
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Sets file path.
     * @param filePath
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public abstract void Validate() throws ParamInvalidException;
}
