package com.jalasoft.webservice.controller;

import com.jalasoft.webservice.utils.Utils;
import org.junit.Test;
import org.springframework.util.FileCopyUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class DownloadControllerTest {
    @Test
    public void download() {
        HttpServletResponse response = null;
        String file = "";
        boolean thrown = false;
        Utils utils = new Utils();
        try {
                response.setContentType("application/octet-stream");
                InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
                FileCopyUtils.copy(inputStream,response.getOutputStream());
        } catch (Exception e) {
            thrown= true;
        }
        assertTrue(thrown);
    }
}