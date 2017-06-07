/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rezwan.textparsedapi.api.endpoint;

import lombok.extern.slf4j.Slf4j;
import org.rezwan.textparsedapi.common.Constants;
import org.rezwan.textparsedapi.core.service.CounterAPITopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author shafin
 */
@Slf4j
@RestController
public class CounterAPITopEndpoint {
    
    @Autowired
    private CounterAPITopService counterAPITopService;
    
    @ResponseBody    
    @RequestMapping(
            value = Constants.API_COUNTER_TOP,
            method = RequestMethod.GET,
            produces = Constants.MEDIA_TYPE_TEXT_CSV
    )
    public String search( @PathVariable("topId") long topId) {
        log.info("Received Top request with TopID :: {}", topId);
        String strResponse = counterAPITopService.processTopRequest(topId);        
        log.info("Responding with :: {}", strResponse);
        return strResponse;
    }    
}
