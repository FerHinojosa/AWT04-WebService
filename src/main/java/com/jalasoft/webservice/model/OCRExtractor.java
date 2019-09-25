/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.jalasoft.webservice.model;

import java.io.File;
import java.io.IOException;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.Tesseract;

/**
 * The class implements methods to convert PDF files into image files, Creates the Controller Model using Tesseract
 * with the wrapper Tess4J.
 *
 * @author Andy Bazualdo on 9/23/19.
 * @version 1.0
 */
public class OCRExtractor implements IConvert {
    private OCRCriteria ocrCriteria;

    /**
     *
     * @param criteria the object have the parameters to start the method execution
     * @return returns the result of the method and error message in case of error
     * @throws IOException get input/output exception to read files
     */
    @Override
    public String convert(Criteria criteria) throws IOException {
        ocrCriteria = (OCRCriteria) criteria;
        File imageFile = new File(ocrCriteria.getFilePath());
        ITesseract tesseract = new Tesseract();
        tesseract.setDatapath("../../../../ThirdParty/Tess4J/tessdata/"); // path to tessdata directory
        tesseract.setLanguage(ocrCriteria.getLang());
        try {
            String result = tesseract.doOCR(imageFile);
            return result;
        } catch (TesseractException e){
            return e.toString();
        }
    }
}
