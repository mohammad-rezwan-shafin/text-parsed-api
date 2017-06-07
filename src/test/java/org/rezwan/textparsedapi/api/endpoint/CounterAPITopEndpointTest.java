/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rezwan.textparsedapi.api.endpoint;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.rezwan.textparsedapi.core.service.CounterAPITopService;

/**
 *
 * @author shafin
 */
@Slf4j
public class CounterAPITopEndpointTest {
    
    @InjectMocks
    private CounterAPITopEndpoint counterAPITopEndpoint;

    @Mock
    private CounterAPITopService counterAPITopService;
    
    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);        
    }
    
    @Test
    public void testSearch() {
        
        long topRequestMock = 2;
        String topResponseMock = "vel|17\neget|17";
        
        Mockito.when(
            counterAPITopService.processTopRequest(
                    2 
            )            
        ).thenReturn(
                topResponseMock
        );

        String topResponse = counterAPITopEndpoint.search(topRequestMock);
        log.info("topResponse = {}, topResponseMock = {}", topResponse, topResponseMock);
        
        Assert.assertEquals(topResponse, topResponseMock) ;
    }
}
