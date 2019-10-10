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

import com.jalasoft.webservice.utils.Checksum;
import com.jalasoft.webservice.utils.Validator;
import org.apache.tika.exception.TikaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;
import ws.schild.jave.*;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

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
     */
    @Override
    public Response convert(Criteria criteria) {
        Response res = new Response();
        Checksum checksum = new Checksum();
        MetadataFileCreator metadataFileCreator = new MetadataFileCreator();
        logger.info("Starting Response Model - Method: " +
        new Object() {}.getClass().getEnclosingMethod().getName());
        try {
            AudioCriteria audiocri = (AudioCriteria) criteria;
            File source = new File(audiocri.getFilePath()) ;
            File target = new File(audiocri.getTarget());
            String zipName = checksum.checksum(audiocri.getTarget());
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
            res.setMessage("Audio conversion successfully.");
            res.setUrl(source.getName());
            ZipFiles zipFiles = new ZipFiles();
            String [] filePaths;
            if(audiocri.getMetadata()){
                filePaths = new String[2];
                filePaths[0] = audiocri.getTarget();
                String fileMetaD;
                fileMetaD = metadataFileCreator.getMetada(audiocri.getTarget());
                filePaths[1] = fileMetaD;
            } else {
                filePaths = new String[1];
                filePaths[0]=audiocri.getTarget();
            }
            zipFiles.zipFiles(filePaths,zipName);
            logger.info("Audio conversion succesfully - Method: " +
            new Object() {}.getClass().getEnclosingMethod().getName());
            audiocri.Validate();
            return res;
        } catch (ParamInvalidException e) {
            res.setStatus(Response.Status.BadRequest);
            logger.error("Audio conversion Param Error - Method: " +
            new Object() {}.getClass().getEnclosingMethod().getName());
            return res;
        }
         catch (EncoderException e) {
            res.setStatus(Response.Status.BadRequest);
            logger.error("Audio conversion Encoder Error - Method: " +
            new Object() {}.getClass().getEnclosingMethod().getName());
            return res;
        } catch (TikaException e) {
            e.printStackTrace();
            return res;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return res;
        } catch (IOException e) {
            e.printStackTrace();
            return res;
        } catch (SAXException e) {
            e.printStackTrace();
            return res;
        }
    }
}
