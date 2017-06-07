/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rezwan.textparsedapi.api.endpoint;

import lombok.extern.slf4j.Slf4j;
import org.rezwan.textparsedapi.api.dto.SearchRequest;
import org.rezwan.textparsedapi.api.dto.SearchResponse;
import org.rezwan.textparsedapi.common.Constants;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
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
public class CounterAPISearchEndpoint {
    
    @ResponseBody    
    @RequestMapping(
            path = Constants.API_COUNTER_API_SEARCH,
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public SearchResponse search(@RequestBody SearchRequest searchRequest) {
        log.info("Received search request :: {}", searchRequest);
        SearchResponse searchResponse = new SearchResponse();
        
        
        
        log.info("Responding with :: {}", searchResponse);
        return searchResponse;
    }
    
}
