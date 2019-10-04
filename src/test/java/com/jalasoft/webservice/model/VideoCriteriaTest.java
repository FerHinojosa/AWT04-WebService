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
 * Implements test for the video Criteria class
 *
 * @author Raul Laredo
 * @version v1.0
 */
public class VideoCriteriaTest {
    private final VideoCriteria videoCriteria= new VideoCriteria();

    /**
     * Implements test for File Path
     */
    @Test
    public void getFilePath() {
        videoCriteria.setFilePath("C:/");
        assertEquals("C:/", videoCriteria.getFilePath());
    }

    /**
     * Implements test for target
     */
    @Test
    public void getTarget() {
        videoCriteria.setFilePath("C:/");
        assertEquals("C:/", videoCriteria.getFilePath());
    }

    /**
     * Implements test for codec
     */
    @Test
    public void getCodec() {
        videoCriteria.setCodec("libmp3lame");
        assertEquals("libmp3lame", videoCriteria.getCodec());
    }

    /**
     *Implements test for Bit Rate
     */
    @Test
    public void getBitRate() {
        videoCriteria.setBitRate(64000);
        assertEquals(64000, videoCriteria.getBitRate());
    }

    /**
     * Implements test for sampling rate
     */
    @Test
    public void getSamplingRate() {
        videoCriteria.setSamplingRate(22050);
        assertEquals(22050, videoCriteria.getSamplingRate());
    }

    /**
     * Implements test for Frame rate
     */
    @Test
    public void getFrameRate() {
        videoCriteria.setFrameRate(24);
        assertEquals(24, videoCriteria.getSamplingRate());
    }

    /**
     * Implements test for first size
     */
    @Test
    public void getSize1() {
        videoCriteria.setSize1(400);
        assertEquals(400, videoCriteria.getSize1());
    }

    /**
     * Implements test for second size
     */
    @Test
    public void getSize2() {
        videoCriteria.setSize2(400);
        assertEquals(400, videoCriteria.getSize2());
    }

    /**
     * Implements test for format
     */
    @Test
    public void getFormat() {
        videoCriteria.setFormat("mp4");
        assertEquals("mp4", videoCriteria.getFormat());
    }

    /**
     * Implements test for video codec
     */
    @Test
    public void getVideoCodec() {
        videoCriteria.setVideoCodec("h264");
        assertEquals("h264", videoCriteria.getVideoCodec());
    }
}
