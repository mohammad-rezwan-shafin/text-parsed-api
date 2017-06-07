/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rezwan.textparsedapi.core.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.rezwan.textparsedapi.core.service.SearchSourceAdapterService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author shafin
 */
@Slf4j
@Service
public class RestSearchSourceAdapterServiceImpl  extends ServiceBase implements SearchSourceAdapterService{
    
    @Value("${org.rezwan.textparsedapi.config.restSearchSourceURL}")
    private String restSearchSourceURL;
    
    @Override
    public String getParagraph() {
        log.info("Received request");
     
        RestTemplate restTemplate = new RestTemplate();
        String strResult = restTemplate.getForObject(restSearchSourceURL, String.class);
        
        log.info("Result from REST Client = {}", strResult);
        return strResult;
    }    
}
