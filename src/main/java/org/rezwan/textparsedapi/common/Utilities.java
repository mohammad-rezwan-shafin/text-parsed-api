/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rezwan.textparsedapi.common;

import java.lang.reflect.Field;

/**
 *
 * @author shafin
 */
public class Utilities {
    public static <S, T> void copyAllMatchedFields(S source, T target) throws Exception{
        Class<?> clazz = source.getClass();
        for (Field field : clazz.getFields()) {
            Object value = field.get(source);
            field.set(target, value);
        }
    }    
}
