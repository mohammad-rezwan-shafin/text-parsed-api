/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rezwan.textparsedapi.core.config;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.rezwan.textparsedapi.common.Constants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 *
 * @author shafin
 */
@Component
public class TextParsedAPIAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
    
    @Value("${org.rezwan.textparsedapi.config.security.realm}")
    private String realm;  

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx)
            throws IOException, ServletException {
        response.addHeader(Constants.HTTP_BASIC_AUTHENTICATE_HEADER, Constants.HTTP_BASIC_AUTHENTICATE_REALM_PREFIX + getRealmName());
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        PrintWriter writer = response.getWriter();
        writer.println("HTTP Status 401 - " + authEx.getMessage());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        setRealmName(realm);
        super.afterPropertiesSet();
    }
}
