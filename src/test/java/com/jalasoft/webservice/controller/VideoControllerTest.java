package com.jalasoft.webservice.controller;
import com.jalasoft.webservice.model.*;
import com.jalasoft.webservice.utils.Checksum;
import com.jalasoft.webservice.utils.Utils;
import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

import static org.junit.Assert.*;
public class VideoControllerTest {
    @Test
    public void convert() {
        boolean thrown = false;
        try{
        MultipartFile file = null;
        String filePath = FileManager.getFilePath(file);
        Checksum checksum1 = new Checksum();
        Response response = new Response();
        DBManager db = new DBManager();
        String checksumResult = checksum1.checksum(filePath);
        VideoCriteria cri = new VideoCriteria();
        Utils utils = new Utils();
        String fileTarget = utils.getPublic() ;
        File tartgetFile = new File(fileTarget);
        IConvert video = new VideoConvert();
        String pathDb = "";
        cri.setFilePath(filePath);
        cri.setTarget(fileTarget);
        video.convert(cri);
        } catch(Exception e){
            thrown = true;
        }
        assertTrue(thrown);
    }
}