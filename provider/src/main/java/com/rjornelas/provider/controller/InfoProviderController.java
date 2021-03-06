package com.rjornelas.provider.controller;

import com.rjornelas.provider.model.InfoProvider;
import com.rjornelas.provider.service.InfoProviderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class InfoProviderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(InfoProviderController.class);

    @Autowired
    private InfoProviderService infoProviderService;

    @GetMapping("/{state}")
    public InfoProvider getInfoProvidersByState(@PathVariable String state){
        LOGGER.info("RECEBIDO INFORMAÇÕES DO FORNECEDOR DE {}", state);
        return infoProviderService.getInfoProvidersByState(state);
    }

}
