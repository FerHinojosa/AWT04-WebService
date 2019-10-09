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
 * Implements the criteria needs to convert the audio in other format.
 *
 * @author Raul Laredo on 9/23/19.
 * @version v1.0
 */
public class AudioCriteria extends Criteria {
    private String target;
    private String codec;
    private int bitRate;
    private int channels;
    private int samplingRate;
    private String format;

    /**
     * Set target file.
     * @param target
     */
    public void setTarget(String target) {
        this.target = target;
    }

    /**
     * Get target file.
     * @return target file.
     */
    public String getTarget() {
        return target;
    }

    /**
     * Get codec for conversion.
     * @return codec for conversion.
     */
    public String getCodec() {
        return codec;
    }

    /**
     * Set codec for conversion.
     * @param codec
     */
    public void setCodec(String codec) {
        this.codec = codec;
    }

    /**
     * Get bit rate for conversion.
     * @return bitrate for conversion.
     */
    public int getBitRate() {
        return bitRate;
    }

    /**
     * Set bit rate for conversion.
     * @param bitRate for conversion.
     */
    public void setBitRate(int bitRate) {
        this.bitRate = bitRate;
    }

    /**
     * Get channels for audio conversion.
     * @return channels for conversion.
     */
    public int getChannels() {
        return channels;
    }

    /**
     * Set channels for audio conversion.
     * @param channels for conversion.
     */
    public void setChannels(int channels) {
        this.channels = channels;
    }

    /**
     * Get Sampling Rate for audio conversion.
     * @return sampleRate for conversion.
     */
    public int getSamplingRate() {
        return samplingRate;
    }

    /**
     * Set Sampling Rate for audio conversion.
     * @param samplingRate for audio conversion.
     */
    public void setSamplingRate(int samplingRate) {
        this.samplingRate = samplingRate;
    }

    /**
     * Get format for audio conversion.
     * @return format for conversion.
     */
    public String getFormat() {
        return format;
    }

    /**
     * Set format for video conversion.
     * @param format for conversion.
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * Implements the validation needs for the conversion of an audio.
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
            throw new ParamInvalidException(10, "format");
        }
        if (this.format.isEmpty()){
            throw new ParamInvalidException(11, "format");
        }
        if (ext == "jpg" || ext == "png" || ext == "gif" || ext == "bmp"){
            throw new ParamInvalidException(12, "format");
        }
    }
}
