/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rezwan.textparsedapi.api.dto;

import java.util.Map;

/**
 *
 * @author shafin
 */

@lombok.Data
@lombok.ToString
public class SearchResponse {
    private Map <String,Long>  [] counts;
}
