package com.jalasoft.webservice.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class OCRExtractorTest {

    @Test
    public void convert() {
        Response res = new  Response();
        res.setStatus(Response.Status.Ok);
        res.setMessage("");
        res.setUrl("www.");

        OCRCriteria cri = new OCRCriteria("eng", "C:/");
        cri.setFilePath(cri.getFilePath());
        cri.setLang(cri.getLang());

        OCRExtractor ocr = new OCRExtractor();

    }
}