package com.rjornelas.provider.controller;

import com.rjornelas.provider.entity.InfoProvider;
import com.rjornelas.provider.service.InfoProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class InfoProviderController {

    @Autowired
    private InfoProviderService infoProviderService;

    @GetMapping("/{state}")
    public InfoProvider getInfoProvidersByState(@PathVariable String state){
        return infoProviderService.getInfoProvidersByState(state);
    }

}
