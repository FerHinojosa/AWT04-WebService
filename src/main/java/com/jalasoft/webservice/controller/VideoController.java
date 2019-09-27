package com.jalasoft.webservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ws.schild.jave.*;
import java.io.File;

/**
 *
 * @project WebService feature(VideoConvert)
 * @author Isaac Vasquez on 09/23/2019
 */
@RestController
@RequestMapping("/api/v1.0/videoConv")
public class VideoController {

    @GetMapping
    public String ConverterVideo () throws EncoderException {
        try {
            File source = new File("C:\\Users\\RaulLaredo\\Desktop\\example.mp4");
            File target = new File("C:\\Users\\RaulLaredo\\Desktop\\target.flv");
            AudioAttributes audio = new AudioAttributes();
            audio.setCodec("libmp3lame");
            audio.setBitRate(new Integer(64000));
            audio.setChannels(new Integer(1));
            audio.setSamplingRate(new Integer(22050));
            VideoAttributes video = new VideoAttributes();
            video.setCodec("flv");
            video.setBitRate(new Integer(160000));
            video.setFrameRate(new Integer(15));
            video.setSize(new VideoSize(400, 300));
            EncodingAttributes attrs = new EncodingAttributes();
            attrs.setFormat("flv");
            attrs.setAudioAttributes(audio);
            attrs.setVideoAttributes(video);
            Encoder encoder = new Encoder();
            encoder.encode(new MultimediaObject(source), target, attrs);
            return "Done";
        } catch (Exception e) {
            return ("error" +e);
        }
    }
}