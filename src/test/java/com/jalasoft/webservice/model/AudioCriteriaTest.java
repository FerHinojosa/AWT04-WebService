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
 * Implements test for the audio Criteria class
 *
 * @author Raul Laredo
 * @version v1.0
 */
public class AudioCriteriaTest {
    private final AudioCriteria audioCriteria = new AudioCriteria();

    /**
     * Implements test for File Path
     */
    @Test
    public void getFilePath() {
        audioCriteria.setFilePath("C/");
        assertEquals("C/", audioCriteria.getFilePath());
    }

    /**
     * Implements test for target
     */
    @Test
    public void getTarget() {
        audioCriteria.setTarget("D:/");
        assertEquals("D:/", audioCriteria.getTarget());
    }

    /**
     * Implements test for codec
     */
    @Test
    public void getCodec() {
        audioCriteria.setCodec("mp3");
        assertEquals("mp3", audioCriteria.getCodec());
    }

    /**
     * Implements test for bit rate
     */
    @Test
    public void getBitRate() {
        audioCriteria.setBitRate(3500);
        assertEquals(3500, audioCriteria.getBitRate());
    }

    /**
     * Implements test for channels
     */
    @Test
    public void getChannels() {
        audioCriteria.setChannels(1);
        assertEquals(1, audioCriteria.getChannels());
    }

    /**
     * Implements test for sampling rate
     */
    @Test
    public void getSamplingRate() {
        audioCriteria.setSamplingRate(22058);
        assertEquals(22058, audioCriteria.getSamplingRate());
    }

    /**
     * Implements test for format
     */
    @Test
    public void getFormat() {
        audioCriteria.setFormat("mp3");
        assertEquals("mp3", audioCriteria.getFormat());
    }
}
