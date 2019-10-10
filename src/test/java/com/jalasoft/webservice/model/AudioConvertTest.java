package com.jalasoft.webservice.model;

import org.junit.Test;
import ws.schild.jave.*;

import java.io.File;

import static org.junit.Assert.*;

public class AudioConvertTest {
    AudioConvert audioConvert = new AudioConvert();
    AudioCriteria criteria = new AudioCriteria();
    @Test
    public void convert() {
        AudioCriteria audiocri = (AudioCriteria) criteria;
        File source = new File("") ;
        File target = new File("");
        //Audio Attributes
        AudioAttributes audio = new AudioAttributes();
        audio.setCodec("libmp3lame");
        audio.setBitRate(64000);
        audio.setChannels(1);
        audio.setSamplingRate(22050);
        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setFormat("mp3");
        attrs.setAudioAttributes(audio);
        Encoder encoder = new Encoder();
        assertNotNull(audio);
    }
}