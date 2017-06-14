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
import org.junit.runner.RunWith;
import org.rezwan.textparsedapi.api.dto.SearchRequest;
import org.rezwan.textparsedapi.api.dto.SearchResponse;
import org.rezwan.textparsedapi.common.Constants;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author shafin
 */
@Slf4j
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(
        classes =  org.rezwan.textparsedapi.core.config.Application.class, 
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT       
)
public class CounterAPISearchEndpointIntegrationTest {

    @LocalServerPort
    private int port;

    private HttpHeaders headers;

    private SearchRequest searchRequestMock;
    private SearchResponse searchResponseMock;

    @Before
    public void init() {
        searchRequestMock = getMockSearchRequest();
        searchResponseMock = getMockSearchResponse();

        headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        headers.add("Authorization", "Basic b3B0dXM6Y2FuZGlkYXRlcw==");
    }

    @Test
    public void testEndToEndAPI() {
        HttpEntity<SearchRequest> requestEntity = new HttpEntity<>(
                searchRequestMock,
                headers
        );

        TestRestTemplate restTemplate = new TestRestTemplate();
        ResponseEntity<SearchResponse> responseEntity = restTemplate.exchange(
                createURLWithPort(Constants.API_COUNTER_API_SEARCH),
                HttpMethod.POST,
                requestEntity,
                SearchResponse.class
        );

        SearchResponse searchResponseApiReturn = responseEntity.getBody();

        log.info("Returned from API = {}", searchResponseApiReturn);
        log.info("Expected = {}", searchResponseMock);

        Assert.assertEquals(searchResponseApiReturn, searchResponseMock);

//        JSONAssert.assertEquals(getMockSearchResponse(), responseEntity.getBody(), false);
    }

    private String createURLWithPort(String strUri) {
        return "http://localhost:" + port + strUri;
    }

    private SearchRequest getMockSearchRequest() {
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.setSearchText(
                new String[]{
                    "Duis",
                    "Sed"
                }
        );
        return searchRequest;
    }

    private SearchResponse getMockSearchResponse() {
        SearchResponse searchResponse = new SearchResponse();

        Map<String, Long> mapDuis = new HashMap<>();
        mapDuis.put("Duis", (long) 11);
        Map<String, Long> mapSed = new HashMap<>();
        mapSed.put("Sed", (long) 16);

        Map<String, Long>[] mapArr = new Map[2];
        mapArr[0] = mapDuis;
        mapArr[1] = mapSed;

        searchResponse.setCounts(mapArr);
        return searchResponse;
    }

}
