/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rezwan.textparsedapi.core.service.impl;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.rezwan.textparsedapi.api.dto.SearchRequest;
import org.rezwan.textparsedapi.api.dto.SearchResponse;
import org.rezwan.textparsedapi.core.service.CounterAPISearchService;
import org.rezwan.textparsedapi.core.service.SearchSourceAdapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author shafin
 */
@Slf4j
@Service
public class CounterAPISearchServiceImpl extends ServiceBase implements CounterAPISearchService {
    
    @Autowired
    private SearchSourceAdapterService adapterService;
    
    @Override
    public SearchResponse processSearchRequest(SearchRequest searchRequest) {
        log.info("Received search request :: {}", searchRequest);

        String sourceText = adapterService.getParagraph();
        log.info("REST Adapter response = {}", sourceText);
        
        SearchResponse searchResponse = this.createSearchResponse(searchRequest, sourceText); 

        log.info("Responding with :: {}", searchResponse);
        return searchResponse;        
    }
    
    private SearchResponse createSearchResponse(SearchRequest searchRequest, String sourceText) {
        SearchResponse searchResponse = new SearchResponse();
        Map<String, Long> [] arrReturn = new Map [searchRequest.getSearchText().length];   
        
        int i=0;
        for(String str:searchRequest.getSearchText()) {            
            String [] strArr = sourceText.toLowerCase().split(str.toLowerCase());

            long longVal = 0;
            if (strArr == null) {
                longVal = 0;
            } else {
                longVal = strArr.length - 1;
            }
            Map <String, Long> mapCounter = new HashMap<>();
            mapCounter.put(str, longVal);
            arrReturn[i++] = mapCounter;
        }
        searchResponse.setCounts(arrReturn);
        return searchResponse;
    }
}
