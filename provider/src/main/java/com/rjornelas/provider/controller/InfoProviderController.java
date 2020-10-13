package com.rjornelas.provider.controller;

import com.rjornelas.provider.entity.InfoProvider;
import com.rjornelas.provider.service.InfoProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/providers")
public class InfoProviderController {

    @Autowired
    private InfoProviderService infoProviderService;

    @RequestMapping("/{estado}")
    public InfoProvider getInfoProvidersByState(@PathVariable String estado){
        return infoProviderService.getInfoProvidersByState(estado);
    }

}
