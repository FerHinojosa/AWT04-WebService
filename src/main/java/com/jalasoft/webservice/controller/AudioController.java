/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.jalasoft.webservice.controller;

import com.jalasoft.webservice.model.*;
import com.jalasoft.webservice.utils.Utils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

/**
 *The class is an endpoint for audio converter
 *
 * @author Isaac Vargas on 09/19/2019
 * @version v1.0
 */
@RestController
@RequestMapping("/api/v1.0/audioConv")
public class AudioController {
    /**
     * Converts to another type of audio
     * @param file has the file to be converted in another type
     * @param nameFile has the nameFile of the output
     * @param codec has the codec to be converted in another type
     * @param bitRate has the bitrate to be converted in another type
     * @param channels has the channels to be converted in another type
     * @param samplingRate has the samplingrate to be converted in another type
     * @param format has the format of the output
     * @return type requested of audio
     * @throws IOException throws the input/output exceptions
     */
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
        String fileTarget = utils.getPublic() + nameFile + "." + format ;
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
