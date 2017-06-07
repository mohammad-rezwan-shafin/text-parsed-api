/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rezwan.textparsedapi.core.service;

import org.rezwan.textparsedapi.api.dto.SearchRequest;
import org.rezwan.textparsedapi.api.dto.SearchResponse;

/**
 *
 * @author shafin
 */
public interface CounterAPISearchService extends ServiceInterface {
    SearchResponse processSearchRequest(SearchRequest searchRequest);    
}
