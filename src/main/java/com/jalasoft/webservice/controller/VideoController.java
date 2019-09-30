package com.jalasoft.webservice.controller;

import com.jalasoft.webservice.model.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

/**
 *
 * @project WebService feature(VideoConvert)
 * @author Isaac Vasquez on 09/23/2019
 */
@RestController
@RequestMapping("/api/v1.0/videoConv")
public class VideoController {
    @PostMapping
    public Response convert (@RequestParam("file") MultipartFile file,
                             @RequestParam(value = "targetFile", defaultValue = "/home/ramalaso/Desktop/target.flv") String targetFile,
                             @RequestParam(value = "codec", defaultValue = "libmp3lame") String codec,
                             @RequestParam(value = "bitRate", defaultValue = "64000") int bitRate,
                             @RequestParam(value = "channels", defaultValue = "1") int channels,
                             @RequestParam(value = "samplingRate", defaultValue = "22050") int samplingRate,
                             @RequestParam(value = "videoCodec", defaultValue = "flv") String videoCodec,
                             @RequestParam(value = "videoBitRate", defaultValue = "160000") int videoBitRate,
                             @RequestParam(value = "frameRate", defaultValue = "15") int frameRate,
                             @RequestParam(value = "sizeX", defaultValue = "400") int size1,
                             @RequestParam(value = "sizeY", defaultValue = "300") int size2,
                             @RequestParam(value = "format", defaultValue = "flv") String format

    ) throws IOException {

        //String filePath = FileManager.getFilePath(file);
        VideoCriteria cri = new VideoCriteria();
        cri.setFilePath("/home/ramalaso/Desktop/example.avi");
        cri.setTarget(targetFile);
        cri.setCodec(codec);
        cri.setBitRate(bitRate);
        cri.setChannels(channels);
        cri.setSamplingRate(samplingRate);
        cri.setVideoCodec(videoCodec);
        cri.setBitRate(videoBitRate);
        cri.setFrameRate(frameRate);
        cri.setSize1(size1);
        cri.setSize2(size2);
        cri.setFormat(format);

        IConvert video = new VideoConvert();
        return video.convert(cri);
    }
}