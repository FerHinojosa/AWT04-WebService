package com.jalasoft.webservice.model;

import com.jalasoft.webservice.utils.Checksum;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;
import org.junit.Test;

import java.awt.image.BufferedImage;
import java.io.File;

import static org.junit.Assert.*;

public class ImageConvertTest {
    ImageConvert imageConvert = new ImageConvert();
    ImageCriteria imgCriteria = new ImageCriteria();
    Checksum checksum = new Checksum();
    MetadataFileCreator metadataFileCreator =new MetadataFileCreator();
    boolean thrown = false;

    @Test
    public void convert() {
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
            String[] filePaths;
            if (imgCriteria.getMetadata()) {
                filePaths = new String[count * 2];
            } else {
                filePaths = new String[count];
            }
            for (int page = 0; page < count; ++page) {
                BufferedImage img = renderer.renderImageWithDPI(page, dpi, ImageType.RGB);
                String fileName = destination + page + "." + ext;
                ImageIOUtil.writeImage(img, fileName, 300);
                filePaths[page] = fileName;
                if (imgCriteria.getMetadata()) {
                    String fileMetaD;
                    fileMetaD = metadataFileCreator.getMetada(fileName);
                    filePaths[page+count] = fileMetaD;
                }
                filePaths[page] = fileName;
            }
        } catch (Exception e){
            thrown = true;
            }
        assertTrue(thrown);
        }
    }
