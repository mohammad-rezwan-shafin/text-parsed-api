/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rezwan.textparsedapi.core.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.rezwan.textparsedapi.api.dto.SearchRequest;
import org.rezwan.textparsedapi.api.dto.SearchResponse;
import org.rezwan.textparsedapi.core.service.CounterAPISearchService;
import org.springframework.stereotype.Service;

/**
 *
 * @author shafin
 */
@Slf4j
@Service
public class CounterAPISearchServiceImpl extends ServiceBase implements CounterAPISearchService{
    
    @Override
    public SearchResponse processSearchRequest(SearchRequest searchRequest) {
        log.info("Received search request :: {}", searchRequest);
        SearchResponse searchResponse = null; 
        
//        SearchResponse searchResponse = counterAPISearchService.processSearchRequest(searchRequest);        
        log.info("Responding with :: {}", searchResponse);
        return searchResponse;        
    }
}
