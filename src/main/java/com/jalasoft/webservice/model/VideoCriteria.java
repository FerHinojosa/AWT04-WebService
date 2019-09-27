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

import java.io.File;

/**
 * Implements the criteria needs for convert the video in other format.
 *
 * @author Raul Laredo
 * @version v1.0
 */
public class VideoCriteria extends Criteria {

     private File target;
     private String setCodec;
     private int setBitRate;
     private int setChannels;
     private int setSamplingRate;
     private int setFrameRate;
     private int setSizeX;
     private int setSizeY;
     private String setFormat;
     private String setAudioAttributes;
     private String setVideoAttributes;

    /**
     * Set target file
     * @param target
     */
    public void setTarget(File target) {
        this.target = target;
    }

    /**
     * Get target file
     * @return
     */
    public File getTarget() {
        return target;
    }


    /**
     *Get codec for conversion
     * @return
     */
    public String getSetCodec() {
        return setCodec;
    }

    /**
     * Set codec for conversion
     * @param setCodec
     */
    public void setSetCodec(String setCodec) {
        this.setCodec = setCodec;
    }

    /**
     * Get bit rate for conversion
     * @return
     */
    public int getSetBitRate() {
        return setBitRate;
    }

    /**
     * Set bit rate for conversion
     * @param setBitRate
     */
    public void setSetBitRate(int setBitRate) {
        this.setBitRate = setBitRate;
    }

    /**
     * Get channels for video conversion
     * @return
     */
    public int getSetChannels() {
        return setChannels;
    }

    /**
     * Set channels for video conversion
     * @param setChannels
     */
    public void setSetChannels(int setChannels) {
        this.setChannels = setChannels;
    }

    /**
     * Get Sampling Rate for video conversion
     * @return
     */
    public int getSetSamplingRate() {
        return setSamplingRate;
    }

    /**
     * Set Sampling Rate for video conversion
     * @param setSamplingRate
     */
    public void setSetSamplingRate(int setSamplingRate) {
        this.setSamplingRate = setSamplingRate;
    }

    /**
     * Get frame rate for video conversion
     * @return
     */
    public int getSetFrameRate() {
        return setFrameRate;
    }

    /**
     * Set frame rate for video conversion
     * @param setFrameRate
     */
    public void setSetFrameRate(int setFrameRate) {
        this.setFrameRate = setFrameRate;
    }

    /**
     * Get Size X for video conversion
     * @return
     */
    public int getSetSizeX() {
        return setSizeX;
    }

    /**
     * Set Size X for video conversion
     * @param setSizeX
     */
    public void setSetSizeX(int setSizeX) {
        this.setSizeX = setSizeX;
    }

    /**
     * Get Size Y for video conversion
     * @return
     */
    public int getSetSizeY() {
        return setSizeY;
    }

    /**
     * Set Size Y for video conversion
     * @param setSizeY
     */
    public void setSetSizeY(int setSizeY) {
        this.setSizeY = setSizeY;
    }

    /**
     * Get format for video conversion
     * @return
     */
    public String getSetFormat() {
        return setFormat;
    }

    /**
     * Set format for video conversion
     * @param setFormat
     */
    public void setSetFormat(String setFormat) {
        this.setFormat = setFormat;
    }

    /**
     * Get attributes for video conversion
     * @return
     */
    public String getSetAudioAttributes() {
        return setAudioAttributes;
    }

    /**
     * Set attributes for video conversion
     * @param setAudioAttributes
     */
    public void setSetAudioAttributes(String setAudioAttributes) {
        this.setAudioAttributes = setAudioAttributes;
    }

    /**
     * Get video attributes for video conversion
     * @return
     */
    public String getSetVideoAttributes() {
        return setVideoAttributes;
    }

    /**
     * Set video attributes for video conversion
     * @param setVideoAttributes
     */
    public void setSetVideoAttributes(String setVideoAttributes) {
        this.setVideoAttributes = setVideoAttributes;
    }

}
