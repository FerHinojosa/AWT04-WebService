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
@RequestMapping("/api/v1.0/audioConv")
public class AudioController {
    @PostMapping
    public Response convert (@RequestParam("file") MultipartFile file,
                             @RequestParam("nameFile") String nameFile,
                             @RequestParam(value = "codec", defaultValue = "libmp3lame") String codec,
                             @RequestParam(value = "bitRate", defaultValue = "64000") int bitRate,
                             @RequestParam(value = "channels", defaultValue = "1") int channels,
                             @RequestParam(value = "samplingRate", defaultValue = "22050") int samplingRate,
                             @RequestParam(value = "format", defaultValue = "mp3") String format
    ) throws IOException {
        Utils utils = new Utils();
        String filePath = FileManager.getFilePath(file);
        String fileTarget = utils.getTemp() + nameFile + "." + format ;
        AudioCriteria cri = new AudioCriteria();
        cri.setFilePath(filePath);
        cri.setTarget(fileTarget);
        cri.setCodec(codec);
        cri.setBitRate(bitRate);
        cri.setChannels(channels);
        cri.setSamplingRate(samplingRate);
        cri.setFormat(format);

        IConvert audio = new AudioConvert();
        return audio.convert(cri);
    }
}
