/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rezwan.textparsedapi.common;

/**
 *
 * @author shafin
 */
public class Constants {
    
    public static final String NEWLINE =  System.getProperty("line.separator");
    
    public static final String MEDIA_TYPE_TEXT_CSV =  "text/csv";
    public static final String HTTP_BASIC_AUTHENTICATE_HEADER =  "WWW-Authenticate";
    public static final String HTTP_BASIC_AUTHENTICATE_REALM_PREFIX =  "Basic realm=";
    
    public static final String API_PARAGRAPH =  "/paragraph";
    public static final String API_COUNTER_API_SEARCH =  "/counter-api/search";
    public static final String API_COUNTER_TOP =  "/counter-api/top/{topId}";
   
}
