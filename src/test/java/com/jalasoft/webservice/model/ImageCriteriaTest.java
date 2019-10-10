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
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Implements test for the ImageCriteria class
 *
 * @author Raul Laredo
 * @version v1.0
 */
public class ImageCriteriaTest {
    private final ImageCriteria imageCriteria = new ImageCriteria();

    /**
     * Implements test for File Path
     */
    @Test
    public void getFilePath() {
        imageCriteria.setFilePath("C:");
        assertEquals("C:", imageCriteria.getFilePath());
    }

    /**
     * Implements test for Dpi
     */
    @Test
    public void getDpi() {
        imageCriteria.setDpi(2000);
        assertEquals(2000, imageCriteria.getDpi());
    }

    /**
     * Implements test for Destination Path
     */
    @Test
    public void getDestinationPath() {
        imageCriteria.setDestinationPath("C:/");
        assertEquals("C:/", imageCriteria.getDestinationPath());
    }

    /**
     * Implements test for Extension
     */
    @Test
    public void getExtension() {
        imageCriteria.setExtension("jpg");
        assertEquals("jpg", imageCriteria.getExtension());
    }

    @Test
    public void validate() {
        String ext =  FilenameUtils.getExtension("C/");
    }
}