package com.jalasoft.webservice.controller;

import com.jalasoft.webservice.model.AudioConvert;
import com.jalasoft.webservice.model.AudioCriteria;
import com.jalasoft.webservice.model.DBManager;
import com.jalasoft.webservice.model.IConvert;
import com.jalasoft.webservice.utils.Checksum;
import com.jalasoft.webservice.utils.Utils;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class AudioControllerTest {
    @Test
    public void convert() {
        AudioController audioController = new AudioController();

        Checksum checksum1 = new Checksum();
        DBManager db = new DBManager();
        boolean thrown = false;
        try {
            String checksumResult = checksum1.checksum("C/");
            AudioCriteria cri = new AudioCriteria();
            Utils utils = new Utils();
            String fileTarget = utils.getPublic();
            File tartgetFile = new File(fileTarget);
            IConvert audio = new AudioConvert();
            String pathDb = "";

            cri.setFilePath("C/");
            cri.setTarget(fileTarget);
            cri.setCodec("mp3");
            cri.setBitRate(2200);
            cri.setChannels(1);
            cri.setSamplingRate(22050);
            cri.setFormat("avi");
            cri.setMetadata(false);
        } catch (Exception ex){
            thrown = true;
        }
        assertTrue(thrown);
    }
}