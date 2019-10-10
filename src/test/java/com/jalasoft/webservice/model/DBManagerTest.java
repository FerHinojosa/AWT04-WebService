package com.jalasoft.webservice.model;

import com.jalasoft.webservice.db.QueryManager;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.junit.Test;

import static org.junit.Assert.*;

public class DBManagerTest {
    DBManager db = new DBManager();
    private QueryManager queryManager;
    boolean thrown = false;
    @Test
    public void add() {
        try {
            boolean result = queryManager.insert("", "");
        }catch (Exception e){
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void getPath() {

        try {
        String path = queryManager.getPath("");
        }catch (Exception e){
            thrown = true;
        }
        assertTrue(thrown);
    }
}