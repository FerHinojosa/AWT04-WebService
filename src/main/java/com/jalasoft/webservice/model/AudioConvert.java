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

import com.jalasoft.webservice.utils.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ws.schild.jave.*;
import java.io.File;
import java.io.IOException;

/**
 * Implements the video convert implementing IConvert for using in the conversion.
 *
 * @author Raul Laredo on 9/23/19.
 * @version v1.0
 */
public class AudioConvert implements IConvert {
    Logger logger = LoggerFactory.getLogger(AudioConvert.class);
    Validator validator = new Validator();

    /**
     * Converts audio extension in another type using the criteria.
     *
     * @param criteria has the params of the convert method.
     * @return video transformed in another video data type.
     * @throws IOException
     */
    @Override
    public Response convert(Criteria criteria) throws IOException {
        Response res = new Response();
        logger.info("Starting Response Model - Method: " + new Object() {}.getClass().getEnclosingMethod().getName());
        try {
            AudioCriteria audiocri = (AudioCriteria) criteria;
            File source = new File(audiocri.getFilePath()) ;
            File target = new File(audiocri.getTarget());
            //Audio Attributes
            AudioAttributes audio = new AudioAttributes();
            audio.setCodec(audiocri.getCodec());
            audio.setBitRate(audiocri.getBitRate());
            audio.setChannels(audiocri.getChannels());
            audio.setSamplingRate(audiocri.getSamplingRate());

            EncodingAttributes attrs = new EncodingAttributes();
            attrs.setFormat(audiocri.getFormat());
            attrs.setAudioAttributes(audio);
            Encoder encoder = new Encoder();
            encoder.encode(new MultimediaObject(source), target, attrs);

            res.setStatus(Response.Status.Ok);
            res.setMessage("Audio conversion succesfully.");
            res.setUrl(source.getName());
            ZipFiles zipFiles = new ZipFiles();
            String [] filePaths = new String[5];
            filePaths[0]=audiocri.getTarget();
            zipFiles.zipFiles(filePaths);
            logger.info("Audio conversion succesfully - Method: " + new Object() {}.getClass().getEnclosingMethod().getName());
            return res;
        } catch (Exception e) {
            res.setStatus(Response.Status.BadRequest);
            logger.error("Audio conversion Error - Method: " + new Object() {}.getClass().getEnclosingMethod().getName());
            return res;
        }
    }
}
