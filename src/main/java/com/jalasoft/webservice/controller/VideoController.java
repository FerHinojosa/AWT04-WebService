/**
 *
 * @project WebService feature(OCRController)
 * @author Raul Laredo on 09/25/2019
 */
package com.jalasoft.webservice.controller;


import com.jalasoft.webservice.model.Criteria;
import com.jalasoft.webservice.model.OCRExtractor;
import com.jalasoft.webservice.model.VideoConvert;
import com.jalasoft.webservice.model.VideoConverterCriteria;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
@RequestMapping ("/api/v1.0/ocr")
public class VideoController {

    @PostMapping
    public String Convert (@RequestParam("file") MultipartFile file,
                           @RequestParam(value = "lang", defaultValue = "") String lang,
                           @RequestParam(value = "audioAttributes", defaultValue = "") String audioAttributes,
                           @RequestParam(value = "codec", defaultValue = "") String codec,
                           @RequestParam(value = "bitRate", defaultValue = "") String bitRate,
                           @RequestParam(value = "channels", defaultValue = "") String channels,
                           @RequestParam(value = "samplingRate", defaultValue = "") String samplingRate,
                           @RequestParam(value = "videoCodec", defaultValue = "") String videoCodec,
                           @RequestParam(value = "videoBitRate", defaultValue = "") String videoBitRate,
                           @RequestParam(value = "frameRate", defaultValue = "") String frameRate,
                           @RequestParam(value = "sizeX", defaultValue = "") String sizeX,
                           @RequestParam(value = "sizeY", defaultValue = "") String sizeY,
                           @RequestParam(value = "format", defaultValue = "") String format
                           ) throws IOException {

        String filePath = "../../../../ThirdParty/Tess4J/tessdata/" + file.getOriginalFilename();
        Path location = Paths.get(filePath);

        Files.copy(file.getInputStream(), location, StandardCopyOption.REPLACE_EXISTING);

        VideoConvert video = new VideoConvert();
        VideoConverterCriteria cri = new VideoConverterCriteria();
        cri.setFilePath(filePath);
        cri.setSetAudioAttributes("");
        
        video.convert((Criteria)cri);

        return "";
    }
}


