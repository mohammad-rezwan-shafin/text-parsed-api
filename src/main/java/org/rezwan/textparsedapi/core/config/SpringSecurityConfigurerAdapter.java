/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rezwan.textparsedapi.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author shafin
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Value("${org.rezwan.textparsedapi.config.security.user}")
    private String user;

    @Value("${org.rezwan.textparsedapi.config.security.password}")
    private String password;

    @Value("${org.rezwan.textparsedapi.config.security.roles}")
    private String roles;  

    @Autowired
    private TextParsedAPIAuthenticationEntryPoint authEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf()
            .disable()
            .authorizeRequests()
            .antMatchers("/paragraph").permitAll()
            .antMatchers("/error").permitAll()
            .anyRequest().authenticated()
            .and().httpBasic()
            .authenticationEntryPoint(authEntryPoint);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
            .withUser(user)
            .password(password)
            .roles(roles);
    }
}
