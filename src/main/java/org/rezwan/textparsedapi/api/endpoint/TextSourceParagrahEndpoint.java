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
import org.rezwan.textparsedapi.core.service.CounterAPISearchService;
import org.rezwan.textparsedapi.core.service.ParagraphService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TextSourceParagrahEndpoint {
    
    @Autowired
    private ParagraphService paragraphService;
    
    @ResponseBody    
    @RequestMapping(
            path = Constants.API_PARAGRAPH,
            method = RequestMethod.GET,
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public String getParagraph() {
        log.info("Received request.");
        String txtParagraph = paragraphService.getParagraph();        
        log.info("Responding with :: {}", txtParagraph);
        return txtParagraph;
    }    
}
