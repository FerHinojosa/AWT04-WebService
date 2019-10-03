package com.jalasoft.webservice.model;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import com.google.gson.Gson;

import org.xml.sax.SAXException;

public class GetMetadata {

    public static void main(final String[] args) throws IOException, TikaException, SAXException {

        //Assume that boy.jpg is in your current directory
        File file = new File("c:\\jala\\progra\\webservice\\AWT04-WebService\\temp\\example.jpg");

        //Parser method parameters
        Parser parser = new AutoDetectParser();
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        FileInputStream inputStream = new FileInputStream(file);
        ParseContext context = new ParseContext();

        parser.parse(inputStream, handler, metadata, context);
        System.out.println(handler.toString());

        //getting the list of all meta data elements
        String[] metadataNames = metadata.names();

        for(String name : metadataNames) {
            System.out.println(name + ": " + metadata.get(name));
        }


        //test andy

        Gson gson = new Gson();
        //convert java object to JSON format
        String json = gson.toJson(metadata);

        System.out.println(json);
        try {
            //write converted json data to a file named "CountryGSON.json"
            FileWriter writer = new FileWriter("./metadata.json");
            writer.write(json);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(json);
    }
}



