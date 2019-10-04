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

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Implements test for the response class
 *
 * @author Raul Laredo
 * @version v1.0
 */
public class ResponseTest {
    private final Response response = new Response();

    /**
     * Implements test for Status
     */
    @Test
    public void getStatus() {
        response.setStatus(Response.Status.Ok);
        assertEquals(Response.Status.Ok, response.getStatus());
    }

    /**
     * Implements test for Url
     */
    @Test
    public void getUrl() {
        response.setUrl("www.jala.com");
        assertEquals("www.jala.com", response.getUrl());
    }

    /**
     * Implements test for Message
     */
    @Test
    public void getMessage() {
        response.setMessage("Expected result");
        assertEquals("Expected result", response.getMessage());
    }
}
