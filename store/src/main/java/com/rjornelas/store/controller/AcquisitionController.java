package com.rjornelas.store.controller;

import com.rjornelas.store.dto.AcquisitionDto;
import com.rjornelas.store.model.Purchase;
import com.rjornelas.store.service.AcquisitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acquisitions")
public class AcquisitionController {

    @Autowired
    private AcquisitionService acquisitionService;

    @PostMapping
    public Purchase buyNewProduct(@RequestBody AcquisitionDto acquisitionDto){
        return acquisitionService.purchase(acquisitionDto);

    }
}
