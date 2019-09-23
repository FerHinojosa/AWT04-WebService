package com.jalasoft.webservice.model;

import java.io.IOException;

/**
 * @author Andy Bazualdo on 9/23/19.
 * @project WebService
 */
public interface IConvert {
    String convert(Criteria criteria) throws IOException;
}