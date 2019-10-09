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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ws.schild.jave.*;
import java.io.File;
import java.io.IOException;

/**
 * Implements the video convert implementing IConvert for using in the conversion.
 *
 * @author Raul Laredo on 09/23/2019
 * @version v1.0
 */
public class VideoConvert implements IConvert {
    Logger logger = LoggerFactory.getLogger(VideoConvert.class);
      /**
      * Converts the data video data type in another type using the criterias
      *
      * @param criteria has the params of the convert method
      * @return the video transformed in another video data type
      * @throws IOException throws input/output exceptions
      */
    @Override
    public Response convert(Criteria criteria) {
        Response res = new Response();
        logger.info("Starting Response Model - Method: " + new Object() {}.getClass().getEnclosingMethod().getName());
        try {
             VideoCriteria videocri = (VideoCriteria)criteria;
             File source = new File(videocri.getFilePath()) ;
             File target = new File(videocri.getTarget());
             //Audio Attributes
             AudioAttributes audio = new AudioAttributes();
             audio.setCodec(videocri.getCodec());
             audio.setBitRate(videocri.getBitRate());
             audio.setChannels(videocri.getChannels());
             audio.setSamplingRate(videocri.getSamplingRate());
            //Video settings
             VideoAttributes video = new VideoAttributes();
             video.setCodec(videocri.getVideoCodec());
             video.setBitRate(videocri.getBitRate());
             video.setFrameRate(videocri.getFrameRate());
             video.setSize(new VideoSize(videocri.getSize1(), videocri.getSize2()));
             EncodingAttributes attrs = new EncodingAttributes();
             attrs.setFormat(videocri.getFormat());
             attrs.setAudioAttributes(audio);
             attrs.setVideoAttributes(video);
             Encoder encoder = new Encoder();
             encoder.encode(new MultimediaObject(source), target, attrs);
             res.setStatus(Response.Status.Ok);
             res.setMessage("Video conversion succesfully.");
             res.setUrl(source.getName());;

             ZipFiles zipFiles = new ZipFiles();
             String [] filePaths = new String[5];
             filePaths[0]=videocri.getTarget();
             zipFiles.zipFiles(filePaths);
             logger.info("Video conversion succesfully - Method: " +
             new Object() {}.getClass().getEnclosingMethod().getName());
             videocri.Validate();
             return res;
        } catch (ParamInvalidException  e) {
              res.setStatus(Response.Status.BadRequest);
              logger.error("Video conversion Error Params - Method: " +
              new Object() {}.getClass().getEnclosingMethod().getName());
               return res;
        } catch (EncoderException e) {
            res.setStatus(Response.Status.BadRequest);
            logger.error("Video conversion Error Encoder- Method: " +
            new Object() {}.getClass().getEnclosingMethod().getName());
            return res;
        }
    }
}
