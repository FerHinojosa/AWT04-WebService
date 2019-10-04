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

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Implements test for the OCR class
 *
 * @author Raul Laredo
 * @version v1.0
 */
public class OCRCriteriaTest extends Criteria {
    private final OCRCriteria ocrCriteria = new OCRCriteria("eng", "C:/");

    /**
     *Implements test for lang
     */
    @Test
    public void getLang() {
        assertEquals("eng", ocrCriteria.getLang());
    }

    /**
     * Implements test for path
     */
    @Test
    public void getPath(){
        assertEquals("C:/", ocrCriteria.getFilePath());
    }
}
