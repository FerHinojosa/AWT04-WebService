package com.jalasoft.webservice.controller;

import com.jalasoft.webservice.utils.Utils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
@RequestMapping("/download")
public class DownloadController {

    @GetMapping("/file/{fileName:.+}")
    public void downloads (
            HttpServletResponse response,
            @PathVariable("fileName") String fileName) throws IOException {
            try{
                File file = new File( "C:\\Users\\RaulLaredo\\Documents\\Prog102\\AWT04-WebService\\publics\\output.wav");
                if (file.exists()){
                    response.setContentType("application/octet-stream");
                    InputStream is = new BufferedInputStream(new FileInputStream(file));
                    FileCopyUtils.copy(is, response.getOutputStream());
                }
            }
           catch(IOException e){
            }
    }
}
