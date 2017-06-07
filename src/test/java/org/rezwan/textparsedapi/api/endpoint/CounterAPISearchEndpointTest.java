/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rezwan.textparsedapi.api.endpoint;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.rezwan.textparsedapi.api.dto.SearchRequest;
import org.rezwan.textparsedapi.api.dto.SearchResponse;
import org.rezwan.textparsedapi.core.service.CounterAPISearchService;

/**
 *
 * @author shafin
 */
@Slf4j
public class CounterAPISearchEndpointTest {
    
    @InjectMocks
    private CounterAPISearchEndpoint counterAPISearchEndpoint;

    @Mock
    private CounterAPISearchService counterAPISearchService;
    
    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);        
    }
    
    private SearchRequest getMockSearchRequest() {
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.setSearchText(
            new String[] {
                "Duis", 
                "Sed"
            }
        );
        return searchRequest;
    }
    
    private SearchResponse getMockSearchResponse() {
        SearchResponse searchResponse = new SearchResponse();
        
        Map <String, Long> mapDuis = new HashMap<>();
        mapDuis.put("Duis", (long)11);
        Map <String, Long> mapSed = new HashMap<>();
        mapSed.put("Sed", (long)16);

        Map <String, Long> [] mapArr = new Map[2];
        mapArr[0] = mapDuis;
        mapArr[1] = mapSed;
        
        searchResponse.setCounts(mapArr);
        return searchResponse;
    }
    
    @Test
    public void testSearch() {
        
        SearchRequest searchRequestMock = getMockSearchRequest();
        SearchResponse searchResponseMock = getMockSearchResponse();
        
        Mockito.when(
            counterAPISearchService.processSearchRequest( 
                    searchRequestMock 
            )            
        ).thenReturn(
                searchResponseMock
        );

        SearchResponse searchResponse = counterAPISearchEndpoint.search(searchRequestMock);
        log.info("searchResponse = {}, searchResponseMock = {}", searchResponse, searchResponseMock);
        
        Assert.assertEquals(searchResponse, searchResponseMock) ;
    }
}
