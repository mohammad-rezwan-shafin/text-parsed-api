/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rezwan.textparsedapi.core.service.impl;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.rezwan.textparsedapi.core.service.WordCounterService;

/**
 *
 * @author shafin
 */
@Slf4j
@Service
public class WordCounterServiceImpl  extends ServiceBase implements WordCounterService {

    @Override
    public Map<String, Long> getWordCounterMap(String sourceText) {     
        log.info("Received with searchText :: {}", sourceText);
        Map<String, Long> mapReturn =                
            Stream.of(sourceText)
                .map(word -> word.split("\\s"))
                .flatMap(Arrays::stream)
                .map(
                    word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase().trim()
                )     
                .filter(word -> word.trim().length() > 0)
                .map(
                    word -> new AbstractMap.SimpleEntry<>( word, 1)
                )
                .collect(
                    groupingBy(
                        AbstractMap.SimpleEntry::getKey, counting()
                    )
                );
        log.info("Map Returned.");
        return mapReturn;
    }
}
