/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rezwan.textparsedapi.core.service;

import java.util.Map;

/**
 *
 * @author shafin
 */
public interface WordCounterService extends ServiceInterface {
    public Map<String, Long> getWordCounterMap(String sourceText);    
}
