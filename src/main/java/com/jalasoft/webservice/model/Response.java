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

/**
 * Implements Responses for implementing response the status of the controller and methods.
 *
 * @author Raul Laredo
 * @version v1.0
 */
public class Response {

    private String url;
    private Status status;
    private String message;
    /**
     * Get Status  for response
     * @param Status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Set Status  for response
     * @param Status
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Get URl  for response
     * @param Status
     */
    public String getUrl() {
        return url;
    }

    /**
     * Set URl  for response
     * @param Status
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Get message  for response
     * @param Status
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set message  for response
     * @param Status
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Status for responding
     */
    public enum Status{
        Ok,
        Created,
        NoContent,
        BadRequest,
        Forbidden,
        NotFound,
        MethodNotAllowed,
        Conflict,
        InternalServerError
    }

}




