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
import com.jalasoft.webservice.db.QueryManager;

/**
 * Implements DB Manager
 *
 * @author Fernando Hinojosa on 10/03/2019
 * @version v1.0
 */
public class DBManager {
    private static QueryManager queryManager;

    /**
     * Implements Add classes
     * @param checksum Unique value
     * @param path Location the file
     * @return true if save in the FileStorage table
     */
    public static boolean add (String checksum, String path) {
        boolean result = queryManager.insert(checksum,path);
        return result;
    }

    /**
     *
     * @param checksum Unique value
     * @return the location the path
     */
    public static String getPath (String checksum) {
        String path = queryManager.getPath(checksum);
        return path;
    }
}
