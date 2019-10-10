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

import com.jalasoft.webservice.utils.Checksum;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;
import org.apache.tika.exception.TikaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * The class implements methods to convert PDF files into image files.
 *
 * @author Andy Bazualdo on 9/23/19.
 * @version v1.0
 */
public class ImageConvert implements IConvert{
    Logger logger = LoggerFactory.getLogger(ImageConvert.class);
    /**
     *  Creates the Controller Model using Tesseract with the wrapper Tess4J.
     *
     */
    public Response convert(Criteria criteria) {
        Response res = new Response();
        MetadataFileCreator metadataFileCreator =new MetadataFileCreator();
        Checksum checksum = new Checksum();
        logger.info("Starting Response Model - Method: " + new Object() {}.getClass().
        getEnclosingMethod().getName());
        ImageCriteria imgCriteria = (ImageCriteria) criteria;
        try {
            String source = imgCriteria.getFilePath();
            String destination = imgCriteria.getDestinationPath();
            int dpi = imgCriteria.getDpi();
            String ext = imgCriteria.getExtension();
            String zipName = checksum.checksum(source);

            //Loading an existing PDF document
            File file = new File(source);
            PDDocument document = PDDocument.load(file);

            //Instantiating the PDFRenderer class
            PDFRenderer renderer = new PDFRenderer(document);
            int count = document.getNumberOfPages();
            String [] filePaths;
            if(imgCriteria.getMetadata()) {
                filePaths = new String[count * 2];
            } else {
                filePaths = new String[count];
            }
            for (int page = 0; page < count; ++page) {
                BufferedImage img = renderer.renderImageWithDPI(page, dpi, ImageType.RGB);
                String fileName = destination + page + "." + ext;
                ImageIOUtil.writeImage(img, fileName, 300);
                filePaths[page]=fileName;
                if (imgCriteria.getMetadata()) {
                    String fileMetaD;
                    fileMetaD = metadataFileCreator.getMetada(fileName);
                    filePaths[page+count] = fileMetaD;
                }
                filePaths[page] = fileName;
            }
            document.close();
            ZipFiles zipFiles = new ZipFiles();
            zipFiles.zipFiles(filePaths,zipName);
            res.setStatus(Response.Status.Ok);
            res.setMessage("Success, file was converted");
            res.setUrl(zipName + ".zip");
            logger.info("Image conversion succesful... - Method: " + new Object() {}.getClass().getEnclosingMethod().getName());
            imgCriteria.Validate();
            return res;
        } catch (IOException e) {
            res.setStatus(Response.Status.BadRequest);
            logger.error("Image conversion Error - Method: " + new Object() {}.getClass().getEnclosingMethod().getName());
            return res;
        }
        catch (ParamInvalidException e) {
            res.setStatus(Response.Status.BadRequest);
            logger.error("Image conversion Error Params- Method: " + new Object() {}.getClass().getEnclosingMethod().getName());
            return res;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return res;
        } catch (SAXException e) {
            e.printStackTrace();
            return res;
        } catch (TikaException e) {
            e.printStackTrace();
            return res;
        }
    }
}
