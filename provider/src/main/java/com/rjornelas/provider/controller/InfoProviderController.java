package com.rjornelas.provider.controller;

import com.rjornelas.provider.model.InfoProvider;
import com.rjornelas.provider.service.InfoProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/info")
public class InfoProviderController {

    @Autowired
    private InfoProviderService infoProviderService;

    @Value("${configVar}")
    private String configVar;

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/{state}")
    public InfoProvider getInfoProvidersByState(@PathVariable String state){
        return infoProviderService.getInfoProvidersByState(state);
    }
    
    @GetMapping
    public String getConfig() {
        var msgConfigVar = String.format("Config Variable: %s", configVar);
        var msgAppName = String.format("Application Name: %s", appName);
        return String.format("%s <br> %s", msgAppName, msgConfigVar);
    }

}
