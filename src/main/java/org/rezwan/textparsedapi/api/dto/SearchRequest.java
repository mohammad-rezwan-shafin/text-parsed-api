/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rezwan.textparsedapi.api.dto;

/**
 *
 * @author shafin
 */

@lombok.Data
@lombok.ToString
public class SearchRequest {
    private String[] searchText;
}
