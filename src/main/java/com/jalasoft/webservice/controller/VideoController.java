package com.jalasoft.webservice.controller;

import com.jalasoft.webservice.model.*;
import com.jalasoft.webservice.utils.Utils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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
                             @RequestParam("nameFile") String nameFile,
                             @RequestParam(value = "codec", defaultValue = "libmp3lame") String codec,
                             @RequestParam(value = "bitRate", defaultValue = "64000") int bitRate,
                             @RequestParam(value = "channels", defaultValue = "1") int channels,
                             @RequestParam(value = "samplingRate", defaultValue = "22050") int samplingRate,
                             @RequestParam(value = "videoCodec", defaultValue = "h264") String videoCodec,
                             @RequestParam(value = "videoBitRate", defaultValue = "160000") int videoBitRate,
                             @RequestParam(value = "frameRate", defaultValue = "24") int frameRate,
                             @RequestParam(value = "sizeX", defaultValue = "400") int size1,
                             @RequestParam(value = "sizeY", defaultValue = "300") int size2,
                             @RequestParam(value = "format", defaultValue = "mp4") String format
    ) throws IOException {
        Utils utils = new Utils();
        String filePath = FileManager.getFilePath(file);
        String fileTarget = utils.getTemp() + nameFile + "." + format ;
        VideoCriteria cri = new VideoCriteria();
        cri.setFilePath(filePath);
        cri.setTarget(fileTarget);
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