/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rezwan.textparsedapi.core.service.impl;

import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.rezwan.textparsedapi.common.Constants;
import org.rezwan.textparsedapi.core.service.CounterAPITopService;
import org.rezwan.textparsedapi.core.service.SearchSourceAdapterService;
import org.rezwan.textparsedapi.core.service.WordCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author shafin
 */
@Slf4j
@Service
public class CounterAPITopServiceImpl extends ServiceBase implements CounterAPITopService {
    
    @Value("${org.rezwan.textparsedapi.config.topCSVSeparator}")
    private String topCSVSeparator;
    
    @Autowired
    private SearchSourceAdapterService adapterService;

    @Autowired
    private WordCounterService wordCounterService;
    
    @Override
    public String processTopRequest(long topId){
        log.info("Received Top request :: {}", topId);

        String sourceText = adapterService.getParagraph();
        log.info("REST Adapter response = {}", sourceText);
        
        Map<String, Long> mapWords = wordCounterService.getWordCounterMap(sourceText);
        
        String strResponse = this.createTopResponse(topId, mapWords); 

        log.info("Responding with :: {}", strResponse);
        return strResponse;        
    }
    
    private String createTopResponse(long topId, Map<String, Long> mapWords) {
        StringBuilder stringBuilderResponse = new StringBuilder();
        mapWords.entrySet()
                .stream()
                .sorted(
                        Map.Entry.<String, Long> comparingByValue().reversed()
                )
                .limit(topId)
                .forEach( 
                    mapWordCount ->  {
                        log.debug("key={}, val={}", mapWordCount.getKey(), mapWordCount.getValue());
                        stringBuilderResponse.append(mapWordCount.getKey());
                        stringBuilderResponse.append(topCSVSeparator);
                        stringBuilderResponse.append(mapWordCount.getValue());
                        stringBuilderResponse.append(Constants.NEWLINE);
                    }
                );
        String strResponse = stringBuilderResponse.toString();
        log.info("Responding with :: {}", strResponse);
        return strResponse;
    }
}
