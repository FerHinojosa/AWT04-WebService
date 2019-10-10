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
import static org.junit.Assert.assertTrue;

/**
 * Implements test for the audio Criteria class
 *
 * @author Raul Laredo
 * @version v1.0
 */
public class AudioCriteriaTest {
    private final AudioCriteria audioCriteria = new AudioCriteria();
    private String target = "C/";
    private String codec="mp3";
    private int bitRate=3500;
    private int channels=1;
    private int samplingRate=2200;
    private String format="wav";
    /**
     * Implements test for File Path
     */
    @Test
    public void getFilePath() {
        audioCriteria.setFilePath(target);
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
        audioCriteria.setCodec(codec);
        assertEquals("mp3", audioCriteria.getCodec());
    }

    /**
     * Implements test for bit rate
     */
    @Test
    public void getBitRate() {
        audioCriteria.setBitRate(bitRate);
        assertEquals(3500, audioCriteria.getBitRate());
    }

    /**
     * Implements test for channels
     */
    @Test
    public void getChannels() {
        audioCriteria.setChannels(channels);
        assertEquals(1, audioCriteria.getChannels());
    }

    /**
     * Implements test for sampling rate
     */
    @Test
    public void getSamplingRate() {
        audioCriteria.setSamplingRate(samplingRate);
        assertEquals(2200, audioCriteria.getSamplingRate());
    }

    /**
     * Implements test for format
     */
    @Test
    public void getFormat() {
        audioCriteria.setFormat(format);
        assertEquals("wav", audioCriteria.getFormat());
    }

    @Test
    public void validate() throws ParamInvalidException {
        boolean thrown = false;
        if(this.codec==null){
            throw new ParamInvalidException(10, "codec");
        }
        if (this.codec.isEmpty()){
            throw new ParamInvalidException(11, "codec");
        }
        if (this.bitRate == 0){
            throw new ParamInvalidException(11, "bitRate");
        }
        if(this.channels==0){
            throw new ParamInvalidException(12, "channels");
        }
        if(this.samplingRate==0){
            throw new ParamInvalidException(12, "samplingRate");
        }
        if(this.format==null){
            throw new ParamInvalidException(10, "format");}
        try {
            audioCriteria.Validate();
        } catch (ParamInvalidException e) {
            thrown= true;
        }
        assertTrue(thrown);
    }
}
