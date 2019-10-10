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
 * The class is an paramInvalidException
 *
 * @author Raul Laredo on 09/19/2019.
 * @version v1.0
 */
public class ParamInvalidException extends Exception {
    int code;
    String message;
    String param;

    public ParamInvalidException (int code, String param){
        this.code = code;
        this.param = param ;
    }

    /**
     * Get the error message for the params
     * @return
     */
    @Override
    public String getMessage(){
        switch (code) {
            case 10:
                this.message="The param " + this + " is null";
                break;
            case 11:
                this.message = "The param " + this + " is empty";
                break;
            case 12:
                this.message = "The param" + this + " is not allowed";
                break;
            default:
                this.message = "The parameter default is wrong";
                break;
        }
        return this.message;
    }
}