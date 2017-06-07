/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rezwan.textparsedapi.core.service.impl;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.rezwan.textparsedapi.core.service.ParagraphService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author shafin
 */
@Slf4j
@Service
public class ParagraphServiceImpl  extends ServiceBase implements ParagraphService {

    @Value("${org.rezwan.textparsedapi.config.paragraphFileLocation}")
    private String paragraphFileLocation;

    private URI fileLocation;

    @PostConstruct
    public void init() {
        try {
            fileLocation = this.getClass()
                    .getClassLoader()
                    .getResource(paragraphFileLocation)
                    .toURI();
        }catch(URISyntaxException urisynex) {
            log.error("Error getting the URI on Paragraph File.", urisynex);
        }
    }

    public String getParagraph() {
        log.info("Received request");
        String strReturn = null;
        try {
            strReturn = Files.lines(
                    Paths.get(fileLocation)
            )
            .collect(Collectors.joining());
        } catch (IOException ioex) {
            log.error("Error reading on Paragraph File.", ioex);
        }
        log.info("Responding with :: {}", strReturn);
        return strReturn;
    }
}
